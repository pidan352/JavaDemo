package com.lyl.test;


import com.lyl.entity.M04MerMultiApp;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.service.M04MerMultiAppService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 功能：批量插入数据，一百万条
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/1 0001
 */

@SpringBootTest
public class InsertData {

    @Resource
    M04MerMultiAppService tm04MerMultiAppService;

    @Resource
    M04MerMultiAppMapper tm04MerMultiAppMapper;

    /**
     * 未开重写sql参数
     * 单线程逐条插入10万条数据
     * <p>
     * 结果：67030毫秒 约1.12分钟
     * 多次测试均在1分钟左右
     */
    @Test
    void test1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("开始");
        for (int i = 1; i <= 100000; i++) {
            M04MerMultiApp m04MerMultiApp = extracted(i);

            boolean j = tm04MerMultiAppService.save(m04MerMultiApp);
            if (j) {
                System.out.println("成功插入第" + i + "条数据");
            } else {
                System.out.println("第" + i + "条数据插入失败");
            }
        }
        stopWatch.stop();
        System.out.println("执行完毕：" + stopWatch.getTotalTimeMillis());
    }


    /**
     * 未开重写sql参数，单线程批量插入10万条数据
     * <p>
     * 每1千条数据执行一次saveBatch
     * <p>
     * 结果：20353毫秒 约20秒
     * 多次测试都是20秒，都是毫秒级不同
     * <p>
     * <p>
     * 开启重写sql参数，结果几乎一致
     * <p>
     * <p>
     * 在不打印sql和输出语句的情况下，时间来到了14秒
     * <p>
     * <p>
     * 插入百万数据时间约为一份45秒
     */
    @Test
    void test2() {
        //StopWatch stopWatch = new StopWatch();
        //stopWatch.start();
        ArrayList<M04MerMultiApp> list = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            M04MerMultiApp m04MerMultiApp = extracted(i);
            list.add(m04MerMultiApp);
            if (i % 10000 == 0) {
                boolean b = tm04MerMultiAppService.saveBatch(list);
                if (b) {
                    System.out.println("批量插入第" + i / 10000 + "次");
                }
                list.clear();
            }
        }
        //stopWatch.stop();
        //System.out.println("执行完毕：" + stopWatch.getTotalTimeMillis());
    }

    /**
     * 单线程批量插入10万条数据,重写参数无效（因为是执行的自定义sql）
     * <p>
     * 每1百条数据执行一次saveBatchTest
     * 因为数据太多时会报错，一次性插入的字段参数过多，不能超过2100个参数
     * <p>
     * 结果：16544毫秒 约16秒
     * <p>
     * 不显示sql和输出语句，时间约为12秒
     * <p>
     * 插入百万数据约为一分28秒
     */
    @Test
    void test3() {
        //StopWatch stopWatch = new StopWatch();
        //stopWatch.start("开始");
        ArrayList<M04MerMultiApp> list = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            M04MerMultiApp m04MerMultiApp = extracted(i);
            list.add(m04MerMultiApp);
            if (i % 100 == 0) {
                boolean b = tm04MerMultiAppService.saveBatchTest(list);
                //if (b) {
                //	System.out.println("批量插入第" + i / 100 + "次");
                //}
                list.clear();
            }
        }
        //stopWatch.stop();
        //System.out.println("执行完毕：" + stopWatch.getTotalTimeMillis());
    }

    /**
     * sql语句是解析了实体类的所有字段，导致参数变多
     * <p>
     * 最终执行时间约为44秒，对于字段多的数据不好用
     */
    @Test
    void test4() {
        ArrayList<M04MerMultiApp> list = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            M04MerMultiApp m04MerMultiApp = extracted(i);
            list.add(m04MerMultiApp);
            if (i % 20 == 0) {
                Integer j = tm04MerMultiAppMapper.insertBatchSomeColumn(list);
                if (j > 0) {
                    System.out.println("批量插入第" + i / 20 + "次");
                }
                list.clear();
            }
        }
    }


    private static M04MerMultiApp extracted(int i) {
        return M04MerMultiApp.builder()
                .id("test" + i)
                .customerId("test" + i)
                .isMain(0L)
                .registerWay(0L)
                .status(0L)
                .headQuartersFlag(0L)
                .isTradeProcess(0L)
                .isSettlement(0L)
                .acquirerNo("test" + i)
                .creater("test" + i)
                .createDate(LocalDateTime.now())
                .lastModifier("test" + i)
                .lastModifyDate(LocalDateTime.now())
                .branch("test" + i)
                .provinceBranch("test" + i)
                .isDelete("0")
                .appCategory(0L)
                .appNo(0L)
                .build();

    }
}