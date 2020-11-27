package com.imlty.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imlty.dao.ResourceMapper;
import com.imlty.domain.Resource;
import com.imlty.service.ResourceService;
import com.imlty.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO) {

        //1.分页查询
        PageHelper.startPage(resourceVO.getCurrentPage(),resourceVO.getPageSize());

        //2.查询
        List<Resource> resourceList = resourceMapper.findAllResourceByPage(resourceVO);

        //3.创建并注入进pageInfo对象
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceList);

        return pageInfo;
    }
}
