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

import javax.annotation.Resource;
import java.util.List;

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
                            new Page<>(0, 100));
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
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 200; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<M04MerMultiApp> data = m04MerMultiAppService.page(new Page<>(i, 5000))
                        .getRecords();
                excelWriter.write(data, writeSheet);
            }
        }
    }
}
