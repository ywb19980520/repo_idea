package com.imlty.service;

import com.imlty.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    /**
     * 获取所有广告位
     */
    List<PromotionSpace> findAllPromotionSpace();

    /**
     * 添加广告位
     * @param promotionSpace
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 修改广告位
     * @param promotionSpace
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据id查询广告位信息
     * @param id
     * @return
     */
    PromotionSpace findPromotionSpaceById(int id);

}
