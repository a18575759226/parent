package com.xmg.shop.service.impl;

import com.xmg.shop.domain.SkuPropertyValue;
import com.xmg.shop.mapper.SkuPropertyValueMapper;
import com.xmg.shop.service.ISkuPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/14.
 */
@Service
public class SkuPropertyValueService implements ISkuPropertyValueService {

    @Autowired
    private SkuPropertyValueMapper skuPropertyValueMapper ;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(SkuPropertyValue record) {
        return 0;
    }

    @Override
    public SkuPropertyValue selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<SkuPropertyValue> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(SkuPropertyValue record) {
        return 0;
    }

    @Override
    public List<SkuPropertyValue> getSkuProperValue(Long skuPropertyId) {
        return skuPropertyValueMapper.getSkuProperValue(skuPropertyId);
    }

    @Override
    public void addSkuPropertyValue(SkuPropertyValue skuPropertyValue) {
        SkuPropertyValue skuValue = new SkuPropertyValue();
        skuValue.setSkuPropertyId(skuPropertyValue.getSkuPropertyId());
        skuValue.setValue(skuPropertyValue.getValue());

        skuPropertyValueMapper.insert(skuValue);

    }

}
