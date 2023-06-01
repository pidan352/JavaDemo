package com.lyl.test;

import com.lyl.entity.TM04MerMultiApp;
import com.lyl.mapper.TM04MerMultiAppMapper;
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
	private TM04MerMultiAppMapper tm04MerMultiAppMapper;

	@Resource
	private TestMapper testMapper;

	@Test
	public void test1() {
		TM04MerMultiApp tm04MerMultiApp = new TM04MerMultiApp();
		tm04MerMultiApp.setId("test3");
		tm04MerMultiApp.setCustomerId("test1");
		tm04MerMultiApp.setIsMain(0d);
		tm04MerMultiApp.setRegisterWay(0d);
		tm04MerMultiApp.setStatus(0d);
		tm04MerMultiApp.setHeadQuartersFlag(0d);
		tm04MerMultiApp.setIsTradeProcess(0d);
		tm04MerMultiApp.setIsSettlement(0d);
		tm04MerMultiApp.setAcquirerNo("test1");
		tm04MerMultiApp.setCreater("test1");
		tm04MerMultiApp.setCreateDate(LocalDateTime.now());
		tm04MerMultiApp.setLastModifier("test1");
		tm04MerMultiApp.setLastModifyDate(LocalDateTime.now());
		tm04MerMultiApp.setBranch("test1");
		tm04MerMultiApp.setProvinceBranch("test1");
		tm04MerMultiApp.setIsDelete("0");
		tm04MerMultiApp.setAppCategory(0d);
		tm04MerMultiApp.setAppNo(0d);

		int i = tm04MerMultiAppMapper.insert(tm04MerMultiApp);
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
		test.setTest(0d);
		test.setMic("test1");
		testMapper.insert(test);
	}
}
