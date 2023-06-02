package com.lyl.service.impl;

import com.lyl.entity.TM04MerMultiApp;
import com.lyl.mapper.TM04MerMultiAppMapper;
import com.lyl.service.ITM04MerMultiAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyl
 * @since 2023-05-30
 */
@Service
public class TM04MerMultiAppServiceImpl extends ServiceImpl<TM04MerMultiAppMapper, TM04MerMultiApp> implements ITM04MerMultiAppService {

	@Override
	public boolean saveBatchTest(List list) {
		return baseMapper.saveBatchTest(list);
	}
}
