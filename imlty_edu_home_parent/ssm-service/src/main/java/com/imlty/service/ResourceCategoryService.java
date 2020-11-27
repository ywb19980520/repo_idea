package com.imlty.service;

import com.imlty.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {
    /**
     * 查询所有资源分类
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();
}
