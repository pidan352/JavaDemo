package com.lyl.mapper;

import com.lyl.entity.TM04MerMultiApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyl.mappers.ExtendBaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2023-05-30
 */
//public interface TM04MerMultiAppMapper extends BaseMapper<TM04MerMultiApp> {
//
//	boolean saveBatchTest(List list);
//}


/**
 * 使用sql注入器拓展basemapper
 */
public interface TM04MerMultiAppMapper extends ExtendBaseMapper<TM04MerMultiApp> {
	boolean saveBatchTest(List list);
}
