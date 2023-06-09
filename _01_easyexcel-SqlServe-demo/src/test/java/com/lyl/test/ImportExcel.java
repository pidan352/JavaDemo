package com.lyl.test;

import com.alibaba.excel.EasyExcel;
import com.lyl.entity.M04MerMultiApp;
import com.lyl.listener.M04AsyncListener;
import com.lyl.listener.M04Listener;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.service.M04MerMultiAppService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 功能：将Excel的百万数据导入到数据库
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/8 0008
 */

@SpringBootTest
public class ImportExcel {

    @Resource
    private M04MerMultiAppMapper m04MerMultiAppMapper;

    @Resource
    private M04MerMultiAppService m04MerMultiAppService;


    /**
     * 最简单的读
     */
    @Test
    public void simpleRead() {
        String fileName = System.getProperty("user.dir") + "\\excel\\1686207644787.xlsx";
        System.out.println(fileName);

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, M04MerMultiApp.class, new M04Listener(m04MerMultiAppService)).sheet().doRead();

        // 一个文件一个reader
//        try (ExcelReader excelReader = EasyExcel.read(fileName, M04MerMultiApp.class, new M04Listener(m04MerMultiAppMapper)).build()) {
//            // 构建一个sheet 这里可以指定名字或者no
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            // 读取一个sheet
//            excelReader.read(readSheet);
//        }
    }

    @Test
    public void asyncRead() throws InterruptedException {
        String fileName = System.getProperty("user.dir") + "\\excel\\1686207644787.xlsx";
        System.out.println(fileName);

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        ExecutorService es = Executors.newFixedThreadPool(20);
        EasyExcel.read(fileName, M04MerMultiApp.class, new M04AsyncListener(m04MerMultiAppService, es)).sheet().doRead();
        //防止main线程结束后程序关闭后，导致线程池中等待队列中任务未执行
        es.shutdown();
        while (!es.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("线程池中任务还未执行完毕");
        }

        // 一个文件一个reader
//        try (ExcelReader excelReader = EasyExcel.read(fileName, M04MerMultiApp.class, new M04Listener(m04MerMultiAppMapper)).build()) {
//            // 构建一个sheet 这里可以指定名字或者no
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            // 读取一个sheet
//            excelReader.read(readSheet);
//        }
    }
}
