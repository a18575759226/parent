package com.xmg.shop.service;

import com.xmg.shop.domain.CatalogProperty;
import com.xmg.shop.domain.CatalogPropertyValue;

import java.util.List;

/**
 * Created by asus on 2017/08/14.
 */
public interface ICatalogPropertyService {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogProperty record);

    CatalogProperty selectByPrimaryKey(Long id);

    List<CatalogProperty> selectAll();

    int updateByPrimaryKey(CatalogProperty record);

    List<CatalogProperty> getCatalogProperty(Long catalogId);


    List<CatalogPropertyValue>getCatalogPropertyValue(Long catalogPropertyId);
}
