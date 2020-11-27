package com.imlty.controller;


import com.imlty.domain.PromotionSpace;
import com.imlty.domain.ResponseResult;
import com.imlty.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;


    /**
     * 查询所有广告位
     * @return
     */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){

        List<PromotionSpace> promotionSpaceList = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResult(true,200,"查询所有成功",promotionSpaceList);
    }
    /**
     * 新增或者修改广告位
     */
    @PostMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        ResponseResult responseResult = new ResponseResult(true,200,"成功",null);
        //判断操作欧式新增还是存储
        if (promotionSpace.getId() != null){
            //更新
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            responseResult.setMessage("更新成功");
        }else {
            //新增
            promotionSpaceService.savePromotionSpace(promotionSpace);
            responseResult.setMessage("保存成功");
        }
        return responseResult;
    }
    /**
     * 根据id 查询广告位信息
     */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult  findPromotionSpaceById(int id){
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResult(true,200,"查询成功",promotionSpace);
    }
}
