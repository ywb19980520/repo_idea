package com.imlty.controller;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.PromotionAd;
import com.imlty.vo.PromotionAdVO;
import com.imlty.domain.ResponseResult;
import com.imlty.service.PromotionAdService;
import com.imlty.utils.UploadPicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 广告信息controller层
 */
@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    /**
     * 分页查询
     * @param promotionAdVO
     * @return
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllAdByPage( PromotionAdVO promotionAdVO){//没有请求体无需添加@Resquestbody
        //获取页面信息
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVO);

        return new ResponseResult(true,200,"查询当前页成功",pageInfo);
    }

    /**
     * 图片上传接口
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileupload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request){
        Map<String, String> map = UploadPicUtils.upload(multipartFile, request);
        return new ResponseResult(true, 200, "上传成功", map);
    }

    /**
     * 广告状态的动态更改
     * @param promotionAd
     * @return
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(PromotionAd promotionAd){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("status",promotionAd.getStatus());
        promotionAdService.updatePromotionStatus(promotionAd);
        return new ResponseResult(true,200,"更新状态成功",map);
    }
}
