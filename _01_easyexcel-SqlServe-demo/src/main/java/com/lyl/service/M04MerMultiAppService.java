package com.lyl.service;

import com.lyl.entity.M04MerMultiApp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
public interface M04MerMultiAppService extends IService<M04MerMultiApp> {

    boolean saveBatchTest(List list);
}
