package com.lyl.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 功能：easyExcel解析数据的监听器
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/1
 */
@Slf4j
public class NoModelDataListener extends AnalysisEventListener<Map<Integer, String>> {

    private final StringBuilder cachedDataStr = new StringBuilder();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        log.info("解析到一条数据：{}", JSON.toJSONString(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
    }
}

