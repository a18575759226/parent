package com.xmg.shop.service;

import com.xmg.shop.domain.SkuPropertyValue;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/14.
 */
public interface ISkuPropertyValueService {

    int deleteByPrimaryKey(Long id);

    int insert(SkuPropertyValue record);

    SkuPropertyValue selectByPrimaryKey(Long id);

    List<SkuPropertyValue> selectAll();

    int updateByPrimaryKey(SkuPropertyValue record);

    /**
     * 获取sku的可选属性值
     * @param skuPropertyId
     * @return
     */
    List<SkuPropertyValue> getSkuProperValue(Long skuPropertyId);

    /**
     * 添加sku的可选值
     * @param skuPropertyId
     * @param value
     */
    void addSkuPropertyValue(SkuPropertyValue skuPropertyValue);
}
