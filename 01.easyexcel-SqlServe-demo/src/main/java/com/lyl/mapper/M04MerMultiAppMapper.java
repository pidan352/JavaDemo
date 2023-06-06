package com.lyl.mapper;

import com.lyl.entity.M04MerMultiApp;
import com.lyl.mappers.ExtendBaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
public interface M04MerMultiAppMapper extends ExtendBaseMapper<M04MerMultiApp> {

    boolean saveBatchTest(List list);

}
