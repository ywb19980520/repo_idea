package com.imlty.dao;

import com.imlty.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    /**
     * 查询所有资源分类
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();
}
