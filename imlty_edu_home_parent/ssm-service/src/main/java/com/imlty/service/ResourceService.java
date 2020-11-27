package com.imlty.service;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.Resource;
import com.imlty.vo.ResourceVO;

public interface ResourceService {

    /**
     * 资源分页以及多条件查询
     */
    PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
