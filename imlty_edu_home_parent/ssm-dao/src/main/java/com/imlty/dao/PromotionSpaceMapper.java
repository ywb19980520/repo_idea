package com.imlty.dao;

import com.imlty.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    /**
     * 获取所有广告位
     */
    List<PromotionSpace> findAllPromotionSpace();

    /**
     * 添加广告位
     */
    void savePromotionSpace(PromotionSpace promotionSpace);
    /**
     * 修改广告位
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);
    /**
     * 根据id查询广告位i信息
     */
    PromotionSpace findPromotionSpaceById(int id);
}