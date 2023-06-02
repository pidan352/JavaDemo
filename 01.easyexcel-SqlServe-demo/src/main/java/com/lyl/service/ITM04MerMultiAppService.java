package com.lyl.service;

import com.lyl.entity.TM04MerMultiApp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2023-05-30
 */
public interface ITM04MerMultiAppService extends IService<TM04MerMultiApp> {

	boolean saveBatchTest(List list);

}
