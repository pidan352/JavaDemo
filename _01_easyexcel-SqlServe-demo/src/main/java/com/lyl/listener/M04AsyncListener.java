package com.lyl.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.lyl.entity.M04MerMultiApp;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.service.M04MerMultiAppService;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/**
 * 功能：多线程操作
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/9 0009
 */

public class M04AsyncListener implements ReadListener<M04MerMultiApp> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private final ArrayList<M04MerMultiApp> cachedDataList = new ArrayList<>();


    /**
     * 线程池
     */
    private ExecutorService es;

    private M04MerMultiAppMapper m04MerMultiAppMapper;

    private M04MerMultiAppService m04MerMultiAppService;

    private volatile int count = 1;

    private volatile int total = 0;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public M04AsyncListener(M04MerMultiAppMapper m04MerMultiAppMapper) {
        this.m04MerMultiAppMapper = m04MerMultiAppMapper;
    }

    public M04AsyncListener(M04MerMultiAppService m04MerMultiAppService, ExecutorService es) {
        this.m04MerMultiAppService = m04MerMultiAppService;
        this.es = es;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(M04MerMultiApp data, AnalysisContext context) {
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            //将解析数据拷贝一份，因为主线程需要继续解析数据到cachedDataList中
            ArrayList<M04MerMultiApp> list = (ArrayList<M04MerMultiApp>) cachedDataList.clone();
            es.submit(() -> {
                m04MerMultiAppService.saveBatchTest(list);
//                synchronized (cachedDataList) {
//                    total += list.size();
//                    System.out.println("第" + count++ + "次插入" + list.size() + "条数据,共计插入" + total + "条数据");
//                }
            });
            //清理List
            cachedDataList.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        if (cachedDataList.size() > 0) {
            es.submit(() -> {
                m04MerMultiAppService.saveBatchTest(cachedDataList);
            });
        }
    }
}
