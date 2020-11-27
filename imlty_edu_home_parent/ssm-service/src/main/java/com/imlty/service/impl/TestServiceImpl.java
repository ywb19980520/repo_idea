package com.imlty.service.impl;

import com.imlty.domain.Test;
import com.imlty.dao.TestMapper;
import com.imlty.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//生成本类的实现类存进ioc容器中
public class TestServiceImpl implements TestService {


    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        return testMapper.findAllTest();
    }
}
