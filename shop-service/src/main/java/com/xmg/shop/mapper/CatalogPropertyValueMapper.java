package com.xmg.shop.mapper;

import com.xmg.shop.domain.CatalogPropertyValue;
import java.util.List;

public interface CatalogPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogPropertyValue record);

    CatalogPropertyValue selectByPrimaryKey(Long id);

    List<CatalogPropertyValue> selectAll();

    int updateByPrimaryKey(CatalogPropertyValue record);

    List<CatalogPropertyValue> getCatalogPropertyValue(Long catalogPropertyId);
}