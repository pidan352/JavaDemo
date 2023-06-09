package com.lyl.test;

import com.lyl.entity.M04MerMultiApp;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/5/30 0030
 */

@SpringBootTest
public class TestSqlServer {

    @Resource
    private M04MerMultiAppMapper m04MerMultiAppMapper;

    @Resource
    private TestMapper testMapper;

    @Test
    public void test1() {
        M04MerMultiApp M04MerMultiApp = extracted();

        int i = m04MerMultiAppMapper.insert(M04MerMultiApp);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }


    @Test
    public void test2() {
        com.lyl.entity.Test test = new com.lyl.entity.Test();
        test.setId("test5");
        test.setTest(0L);
        test.setMic("test1");
        testMapper.insert(test);
    }

    private static M04MerMultiApp extracted() {
        return M04MerMultiApp.builder()
                .id("test3")
                .customerId("test1")
                .isMain(0L)
                .registerWay(0L)
                .status(0L)
                .headQuartersFlag(0L)
                .isTradeProcess(0L)
                .isSettlement(0L)
                .acquirerNo("test1")
                .creater("test1")
                .createDate(LocalDateTime.now())
                .lastModifier("test1")
                .lastModifyDate(LocalDateTime.now())
                .branch("test1")
                .provinceBranch("test1")
                .isDelete("0")
                .appCategory(0L)
                .appNo(0L)
                .build();
    }
}
