package com.xmg.shop.mapper;

import com.xmg.shop.domain.ProductCatalogPropertyValue;

import java.util.List;

public interface ProductCatalogPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCatalogPropertyValue record);

    ProductCatalogPropertyValue selectByPrimaryKey(Long id);

    List<ProductCatalogPropertyValue> selectAll();

    int updateByPrimaryKey(ProductCatalogPropertyValue record);
}