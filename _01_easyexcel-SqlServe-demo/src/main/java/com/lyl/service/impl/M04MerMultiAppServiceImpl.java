package com.lyl.service.impl;

import com.lyl.entity.M04MerMultiApp;
import com.lyl.mapper.M04MerMultiAppMapper;
import com.lyl.service.M04MerMultiAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
@Service
public class M04MerMultiAppServiceImpl extends ServiceImpl<M04MerMultiAppMapper, M04MerMultiApp> implements M04MerMultiAppService {

    @Override
    public boolean saveBatchTest(List list) {
        return baseMapper.saveBatchTest(list);
    }
}
