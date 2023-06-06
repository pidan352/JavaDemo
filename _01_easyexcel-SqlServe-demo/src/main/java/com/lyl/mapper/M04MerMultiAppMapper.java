package com.lyl.mapper;

import com.lyl.entity.M04MerMultiApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
public interface M04MerMultiAppMapper extends BaseMapper<M04MerMultiApp> {

    boolean saveBatchTest(List list);
}
