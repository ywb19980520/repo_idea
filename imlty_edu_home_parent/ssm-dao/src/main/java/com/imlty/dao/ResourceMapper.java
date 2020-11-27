package com.imlty.dao;

import com.imlty.domain.Resource;
import com.imlty.vo.ResourceVO;

import java.util.List;

public interface ResourceMapper {

    /**
     * 资源分页以及多条件查询
     */
    List<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
