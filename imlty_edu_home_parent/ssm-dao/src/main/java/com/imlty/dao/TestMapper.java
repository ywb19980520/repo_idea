package com.imlty.dao;

import com.imlty.domain.Test;

import java.util.List;

public interface TestMapper {

    /**
     * 查询所有
     */
    List<Test> findAllTest();
}
