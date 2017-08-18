package com.xmg.shop.service;

import com.xmg.shop.domain.CatalogPropertyValue;

import java.util.List;

/**
 * Created by asus on 2017/08/14.
 */
public interface ICatalogPropertyValueService {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogPropertyValue record);

    CatalogPropertyValue selectByPrimaryKey(Long id);

    List<CatalogPropertyValue> selectAll();

    int updateByPrimaryKey(CatalogPropertyValue record);
}
