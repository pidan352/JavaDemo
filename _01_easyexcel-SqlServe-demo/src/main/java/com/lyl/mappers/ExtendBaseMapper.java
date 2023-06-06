package com.lyl.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.Collection;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/2 0002
 */

public interface ExtendBaseMapper<T> extends BaseMapper<T> {

	/**
	 * 批量插入
	 *
	 * @param entityList 实体列表
	 * @return 影响行数
	 */
	Integer insertBatchSomeColumn(Collection<T> entityList);
}
