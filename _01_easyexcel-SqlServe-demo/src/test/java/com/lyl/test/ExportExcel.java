package com.lyl.test;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
		//EasyExcel.write(fileName, TM04MerMultiApp.class)
		//		.sheet("测试1")
		//		.doWrite(() -> {
		//			Page<TM04MerMultiApp> page = m04MerMultiAppService.page(new Page<>(0, 100));
		//			List<TM04MerMultiApp> tm04MerMultiAppList = page.getRecords();
		//			System.out.println(tm04MerMultiAppList.size());
		//			return tm04MerMultiAppList;
		//		});

		EasyExcel.write(fileName, com.lyl.entity.Test.class)
				.sheet("测试1")
				.doWrite(() -> {
					Page<com.lyl.entity.Test> page = testService.page(new Page<>(0, 100));
					List<com.lyl.entity.Test> tm04MerMultiAppList = page.getRecords();
					System.out.println(tm04MerMultiAppList.size());
					return tm04MerMultiAppList;
				});

	}
}
