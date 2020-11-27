package com.imlty.service;

import com.github.pagehelper.PageInfo;
import com.imlty.domain.PromotionAd;
import com.imlty.vo.PromotionAdVO;

public interface PromotionAdService {

    /**
     * 广告信息的分页查询
     * @param promotionAdVO
     * @return
     */
    PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);
    /**
     * 广告的动态上下线
     * @param promotionAd
     */
    void updatePromotionStatus(PromotionAd promotionAd);
}
