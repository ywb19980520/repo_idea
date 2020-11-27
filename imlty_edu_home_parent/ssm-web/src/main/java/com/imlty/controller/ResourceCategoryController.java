package com.imlty.controller;

import com.imlty.domain.ResourceCategory;
import com.imlty.domain.ResponseResult;
import com.imlty.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;


    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true,200,"查询资源分类目录成功",resourceCategoryList);
    }
}
