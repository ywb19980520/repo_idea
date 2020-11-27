package com.imlty.controller;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.Resource;
import com.imlty.domain.ResponseResult;
import com.imlty.service.ResourceService;
import com.imlty.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class RescourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询所有资源信息
     * @param resourceVO
     * @return
     */
    @PostMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO){
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVO);
        return new ResponseResult(true,200,"查询信息分页多条件查询成功",pageInfo);
    }
}
