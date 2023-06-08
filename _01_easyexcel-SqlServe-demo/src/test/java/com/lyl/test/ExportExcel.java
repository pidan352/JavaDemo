package com.lyl.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyl.entity.M04MerMultiApp;
import com.lyl.service.M04MerMultiAppService;
import com.lyl.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能：测试将百万数据导出为Excel
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/2 0002
 */

@SpringBootTest
public class ExportExcel {

    static final String EXCEL_OUTPUT_PATH = System.getProperty("user.dir") + "\\excel\\";

    @Resource
    private M04MerMultiAppService m04MerMultiAppService;

    @Resource
    private TestService testService;

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link com.lyl.entity.M04MerMultiApp}
     * <p>
     * 2. 直接写即可
     */
    @Test
    void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入
        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, M04MerMultiApp.class)
                .sheet("测试1")
                .doWrite(() -> {
                    Page<M04MerMultiApp> page = m04MerMultiAppService.page(
                            new Page<>(2, 10));
                    List<M04MerMultiApp> tm04MerMultiAppList = page.getRecords();
                    System.out.println(tm04MerMultiAppList.size());
                    return tm04MerMultiAppList;
                });

//        EasyExcel.write(fileName, com.lyl.entity.Test.class)
//                .sheet("测试1")
//                .doWrite(() -> {
//                    Page<com.lyl.entity.Test> page = testService.page(new Page<>(0, 100));
//                    List<com.lyl.entity.Test> tm04MerMultiAppList = page.getRecords();
//                    System.out.println(tm04MerMultiAppList.size());
//                    return tm04MerMultiAppList;
//                });

    }

    @Test
    void repeatWrite() {
        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, M04MerMultiApp.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();

            //单sheet最多有1048576行,数据量超过的话还是需要严谨一点做判断的
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < 200; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                Page<M04MerMultiApp> page1 = new Page<>(i, 5000);
                //这样就不会弹出jsqlparse的异常了
                page1.setOptimizeCountSql(false);
                Page<M04MerMultiApp> page = m04MerMultiAppService.page(page1);

                excelWriter.write(page.getRecords(), writeSheet);
            }
            stopWatch.stop();
            System.out.println("运行时间：" + stopWatch.getTotalTimeSeconds());
        }
    }

    /**
     * 采用多线程方式将数据写入Excel
     * <p>
     * easyExcel不支持单个文件的并发读写，寄。
     */
    @Test
    void asyncRepeatWrite() {
        int thread = 5;
        //数据量
        long total = m04MerMultiAppService.count();
        //每个线程平均处理的数据量
        int pageSize = (int) (total / thread + (total % thread == 0 ? 0 : 1));
        System.out.println("每个线程处理的数据量：" + pageSize);
        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
        ExecutorService es = Executors.newFixedThreadPool(thread);

        try {
            ExcelWriter excelWriter = EasyExcel.write(fileName, M04MerMultiApp.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
            Object o = new Object();
            //5个线程读取数据库数据并写入到同一个Excel
            for (int i = 0; i < thread; i++) {
                // 分页去数据库查询数据
                Page<M04MerMultiApp> page1 = new Page<>(i + 1, pageSize);
                //这样就不会弹出jsqlparse的异常了
                page1.setOptimizeCountSql(false);
                List<M04MerMultiApp> list = m04MerMultiAppService.page(page1).getRecords();
                es.submit(() -> {
                    System.out.println("线程" + Thread.currentThread().getName() + "开始将数据写入Excel");
                    try {
                        synchronized (o) {
                            excelWriter.write(list, writeSheet);
                        }
                    } catch (Exception e) {
                        System.out.println("线程" + Thread.currentThread().getName() + "写入Excel出现异常");
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "结束");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试百万数据写入时的时间，即不算读取数据库数据的时间
     */
    @Test
    void writeTime() {
        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
        StopWatch sw = new StopWatch();
        StopWatch sw2 = new StopWatch();
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, M04MerMultiApp.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("测试1").build();
            sw.start();
            List<M04MerMultiApp> list = m04MerMultiAppService.list();
            sw.stop();
            System.out.println("数据库查询时间:" + sw.getTotalTimeSeconds());

            //每次写入1000条，计算写入次数
            int pageSize = 1000;
            int count = list.size() / pageSize + (list.size() % pageSize != 0 ? 1 : 0);
            sw2.start();
            for (int i = 0; i < count; i++) {
                excelWriter.write(list.subList(i * pageSize, (i + 1) * pageSize), writeSheet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        sw2.stop();
        System.out.println("写入时间" + sw2.getTotalTimeSeconds());
    }

//    @Test
//    void writeTime() {
//        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
//        StopWatch sw = new StopWatch();
//        EasyExcel.write(fileName, M04MerMultiApp.class)
//                .sheet("测试1")
//                .doWrite(() -> {
//                    StopWatch stopWatch = new StopWatch();
//                    stopWatch.start();
//                    List<M04MerMultiApp> list = m04MerMultiAppService.list();
//                    stopWatch.stop();
//                    System.out.println("数据库查询时间:" + stopWatch.getTotalTimeSeconds());
//                    System.out.println(list.size());
//                    sw.start();
//                    return list;
//                });
//        sw.stop();
//        System.out.println("写入时间" + sw.getTotalTimeSeconds());
//    }


    @Test
    void asyncRepeatread() {
        int thread = 8;
        //数据量
        long total = m04MerMultiAppService.count();
        //每个线程平均处理的数据量
        int pageSize = (int) (total / thread + (total % thread == 0 ? 0 : 1));
        String fileName = EXCEL_OUTPUT_PATH + System.currentTimeMillis() + ".xlsx";
        ExecutorService es = Executors.newFixedThreadPool(thread);


        HashMap<String, List<M04MerMultiApp>> map = new HashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(thread);

        //线程先将数据读取出来
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < thread; i++) {
            int finalI = i;
            es.submit(() -> {
                // 分页去数据库查询数据
                Page<M04MerMultiApp> page1 = new Page<>(finalI + 1, pageSize);
                //这样就不会弹出jsqlparse的异常了
                page1.setOptimizeCountSql(false);
                map.put(finalI + "", m04MerMultiAppService.page(page1).getRecords());
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();
        System.out.println("查询数据库耗时：" + stopWatch.getTotalTimeSeconds());
        ExcelWriter excelWriter = EasyExcel.write(fileName, M04MerMultiApp.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
        for (int i = 0; i < thread; i++) {
            excelWriter.write(map.get(i + ""), writeSheet);
        }
        //保证数据写入到excel文件中
        excelWriter.finish();
    }
}