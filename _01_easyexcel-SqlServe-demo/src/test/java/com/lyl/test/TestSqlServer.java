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
		M04MerMultiApp M04MerMultiApp = new M04MerMultiApp();
		extracted(M04MerMultiApp);

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

	private static void extracted(M04MerMultiApp M04MerMultiApp) {
		M04MerMultiApp.setId("test3")
				.setCustomerId("test1")
				.setIsMain(0L)
				.setRegisterWay(0L)
				.setStatus(0L)
				.setHeadQuartersFlag(0L)
				.setIsTradeProcess(0L)
				.setIsSettlement(0L)
				.setAcquirerNo("test1")
				.setCreater("test1")
				.setCreateDate(LocalDateTime.now())
				.setLastModifier("test1")
				.setLastModifyDate(LocalDateTime.now())
				.setBranch("test1")
				.setProvinceBranch("test1")
				.setIsDelete("0")
				.setAppCategory(0L)
				.setAppNo(0L);
	}
}
