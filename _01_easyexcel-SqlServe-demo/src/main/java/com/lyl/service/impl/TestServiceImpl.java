package com.lyl.service.impl;

import com.lyl.entity.Test;
import com.lyl.mapper.TestMapper;
import com.lyl.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
