package com.xqy.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xqy.gulimall.coupon.entity.SeckillSkuRelationEntity;
import com.xqy.gulimall.coupon.service.SeckillSkuRelationService;
import com.xqy.common.utils.PageUtils;
import com.xqy.common.utils.R;



/**
 * 秒杀活动商品关联
 *
 * @author xieqianyu
 * @email 119596909@qq.com
 * @date 2022-12-06 10:21:01
 */
@RestController
@RequestMapping("coupon/seckillskurelation")
public class SeckillSkuRelationController {
    @Autowired
    private SeckillSkuRelationService seckillSkuRelationService;
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("coupon:seckillskurelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = seckillSkuRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("coupon:seckillskurelation:info")
    public R info(@PathVariable("id") Long id){
		SeckillSkuRelationEntity seckillSkuRelation = seckillSkuRelationService.getById(id);

        return R.ok().put("seckillSkuRelation", seckillSkuRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("coupon:seckillskurelation:save")
    public R save(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
		seckillSkuRelationService.save(seckillSkuRelation);
        Set<String> keys = redisTemplate.keys("seckill:" + "*");
        if (keys != null) {
            redisTemplate.delete(keys);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("coupon:seckillskurelation:update")
    public R update(@RequestBody SeckillSkuRelationEntity seckillSkuRelation){
		seckillSkuRelationService.updateById(seckillSkuRelation);
        Set<String> keys = redisTemplate.keys("seckill:" + "*");
        if (keys != null) {
            redisTemplate.delete(keys);
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:seckillskurelation:delete")
    public R delete(@RequestBody Long[] ids){
		seckillSkuRelationService.removeByIds(Arrays.asList(ids));
        Set<String> keys = redisTemplate.keys("seckill:" + "*");
        if (keys != null) {
            redisTemplate.delete(keys);
        }
        return R.ok();
    }

}
