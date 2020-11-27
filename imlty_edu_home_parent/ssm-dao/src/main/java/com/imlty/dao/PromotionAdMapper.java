package com.imlty.dao;

import com.imlty.domain.PromotionAd;

import java.util.List;

/**
 * 广告信息处理
 */
public interface PromotionAdMapper {

    /**
     * 分页查询信息
     */
    List<PromotionAd> findAllPromotionAdByPage();

    /**
     * 广告的动态上下线
     * @param promotionAd
     */
    void updatePromotionStatus(PromotionAd promotionAd);

}
