package com.lyl.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.lyl.entity.M04MerMultiApp;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.service.M04MerMultiAppService;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private ArrayList<M04MerMultiApp> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 线程池
     */
    private final ExecutorService es = Executors.newFixedThreadPool(5);

    private M04MerMultiAppMapper m04MerMultiAppMapper;

    private M04MerMultiAppService m04MerMultiAppService;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public M04AsyncListener(M04MerMultiAppMapper m04MerMultiAppMapper) {
        this.m04MerMultiAppMapper = m04MerMultiAppMapper;
    }

    public M04AsyncListener(M04MerMultiAppService m04MerMultiAppService) {
        this.m04MerMultiAppService = m04MerMultiAppService;
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
        //将解析数据拷贝一份，因为主线程需要继续解析数据到cachedDataList中
        ArrayList<M04MerMultiApp> list = (ArrayList<M04MerMultiApp>) cachedDataList.clone();
        if (cachedDataList.size() >= BATCH_COUNT) {
            es.submit(() -> {
                m04MerMultiAppService.saveBatchTest(list);
            });
            //清理 cachedDataList
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
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
        if (cachedDataList.size() > 0)
            es.submit(() -> {
                //将解析数据拷贝一份，因为主线程需要继续解析数据到cachedDataList中
                m04MerMultiAppService.saveBatchTest(cachedDataList);
            });
    }
}
