package com.imlty.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imlty.dao.PromotionAdMapper;
import com.imlty.domain.PromotionAd;
import com.imlty.vo.PromotionAdVO;
import com.imlty.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /**
     * 分压查询的实现
     * @param promotionAdVO
     * @return
     */
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {


        //1 在查询所有信息之前调用PageHelper方法
        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());

        //2 执行查询所有信息的方法
        List<PromotionAd> promotionAdList = promotionAdMapper.findAllPromotionAdByPage();

        //3 将结果分装到PageInfo对象中
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(promotionAdList);
        return pageInfo;
    }

    @Override
    public void updatePromotionStatus(PromotionAd promotionAd) {
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionStatus(promotionAd);
    }
}
