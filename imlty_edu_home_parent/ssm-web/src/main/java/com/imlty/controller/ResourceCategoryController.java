package com.imlty.controller;

import com.imlty.domain.ResourceCategory;
import com.imlty.domain.ResponseResult;
import com.imlty.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 回显所有资源目录信息
     * @return
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true,200,"查询资源分类目录成功",resourceCategoryList);
    }

    /**
     * 修改&&新增资源目录信息
     * @param resourceCategory
     * @return
     */
    @PostMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){
        //判断
        ResponseResult result = new ResponseResult(true,200,"更新成功",resourceCategory);
        if (resourceCategory.getId() != null){
            //修改操作
            resourceCategoryService.updateResourceCategory(resourceCategory);
        }else {
            //新增操作
            resourceCategoryService.saveResourceCategory(resourceCategory);
            result.setMessage("新增成功");
        }
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){

        return new ResponseResult(true,200,"删除资源目录成功",null);
    }

}
