package com.xqy.gulimall.product.vo;

import com.xqy.gulimall.product.entity.SkuInfoEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 秒杀信息签证官
 *
 * @author xqy
 * @date 2023/08/15
 */
@Data
public class SeckillInfoVo {
    private Long id;
    /**
     * 活动id
     */
    private Long promotionId;
    /**
     * 活动场次id
     */
    private Long promotionSessionId;
    /**
     * 商品id
     */
    private Long skuId;

    /**
     * 商品秒杀随机码
     */
    private String randomCode;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;
    /**
     * 秒杀总量
     */
    private Integer seckillCount;
    /**
     * 每人限购数量
     */
    private Integer seckillLimit;
    /**
     * 排序
     */
    private Integer seckillSort;

    //sku的详细信息

    //秒杀开始时间
    private Long startTime;
    //秒杀结束时间
    private Long endTime;
}
