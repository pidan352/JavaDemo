package com.lyl.test;

import com.lyl.entity.TM04MerMultiApp;
import com.lyl.mapper.TM04MerMultiAppMapper;
import com.lyl.mapper.TestMapper;
import com.lyl.service.ITM04MerMultiAppService;
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
	ITM04MerMultiAppService tm04MerMultiAppService;

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
			TM04MerMultiApp tm04MerMultiApp = new TM04MerMultiApp();
			tm04MerMultiApp.setId("test" + i);
			tm04MerMultiApp.setCustomerId("test" + i);
			tm04MerMultiApp.setIsMain(0d);
			tm04MerMultiApp.setRegisterWay(0d);
			tm04MerMultiApp.setStatus(0d);
			tm04MerMultiApp.setHeadQuartersFlag(0d);
			tm04MerMultiApp.setIsTradeProcess(0d);
			tm04MerMultiApp.setIsSettlement(0d);
			tm04MerMultiApp.setAcquirerNo("test" + i);
			tm04MerMultiApp.setCreater("test" + i);
			tm04MerMultiApp.setCreateDate(LocalDateTime.now());
			tm04MerMultiApp.setLastModifier("test" + i);
			tm04MerMultiApp.setLastModifyDate(LocalDateTime.now());
			tm04MerMultiApp.setBranch("test" + i);
			tm04MerMultiApp.setProvinceBranch("test" + i);
			tm04MerMultiApp.setIsDelete("0");
			tm04MerMultiApp.setAppCategory(0d);
			tm04MerMultiApp.setAppNo(0d);

			boolean j = tm04MerMultiAppService.save(tm04MerMultiApp);
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
	 *
	 *
	 * 在不打印sql的情况下，时间来到了14秒
	 */
	@Test
	void test2() {
		//StopWatch stopWatch = new StopWatch();
		//stopWatch.start();
		ArrayList<TM04MerMultiApp> list = new ArrayList<>();
		for (int i = 1; i <= 100000; i++) {
			TM04MerMultiApp tm04MerMultiApp = new TM04MerMultiApp();
			tm04MerMultiApp.setId("test" + i);
			tm04MerMultiApp.setCustomerId("test" + i);
			tm04MerMultiApp.setIsMain(0d);
			tm04MerMultiApp.setRegisterWay(0d);
			tm04MerMultiApp.setStatus(0d);
			tm04MerMultiApp.setHeadQuartersFlag(0d);
			tm04MerMultiApp.setIsTradeProcess(0d);
			tm04MerMultiApp.setIsSettlement(0d);
			tm04MerMultiApp.setAcquirerNo("test" + i);
			tm04MerMultiApp.setCreater("test" + i);
			tm04MerMultiApp.setCreateDate(LocalDateTime.now());
			tm04MerMultiApp.setLastModifier("test" + i);
			tm04MerMultiApp.setLastModifyDate(LocalDateTime.now());
			tm04MerMultiApp.setBranch("test" + i);
			tm04MerMultiApp.setProvinceBranch("test" + i);
			tm04MerMultiApp.setIsDelete("0");
			tm04MerMultiApp.setAppCategory(0d);
			tm04MerMultiApp.setAppNo(0d);

			list.add(tm04MerMultiApp);
			if (i % 1000 == 0) {
				boolean b = tm04MerMultiAppService.saveBatch(list);
				//if (b) {
				//	System.out.println("批量插入第" + i / 10000 + "次");
				//}
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
	 *
	 */
	@Test
	void test3() {
		//StopWatch stopWatch = new StopWatch();
		//stopWatch.start("开始");
		ArrayList<TM04MerMultiApp> list = new ArrayList<>();
		for (int i = 1; i <= 100000; i++) {
			TM04MerMultiApp tm04MerMultiApp = new TM04MerMultiApp();
			tm04MerMultiApp.setId("test" + i);
			tm04MerMultiApp.setCustomerId("test" + i);
			tm04MerMultiApp.setIsMain(0d);
			tm04MerMultiApp.setRegisterWay(0d);
			tm04MerMultiApp.setStatus(0d);
			tm04MerMultiApp.setHeadQuartersFlag(0d);
			tm04MerMultiApp.setIsTradeProcess(0d);
			tm04MerMultiApp.setIsSettlement(0d);
			tm04MerMultiApp.setAcquirerNo("test" + i);
			tm04MerMultiApp.setCreater("test" + i);
			tm04MerMultiApp.setCreateDate(LocalDateTime.now());
			tm04MerMultiApp.setLastModifier("test" + i);
			tm04MerMultiApp.setLastModifyDate(LocalDateTime.now());
			tm04MerMultiApp.setBranch("test" + i);
			tm04MerMultiApp.setProvinceBranch("test" + i);
			tm04MerMultiApp.setIsDelete("0");
			tm04MerMultiApp.setAppCategory(0d);
			tm04MerMultiApp.setAppNo(0d);

			list.add(tm04MerMultiApp);
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
}
