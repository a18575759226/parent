package com.xmg.shop.mapper;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.ProductCatalogPropertyValue;
import com.xmg.shop.query.QueryObject;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    Long count(QueryObject qo);

    List<Product> queryPage(QueryObject qo);

    /**
     * 通过产品id获取所有的属性
     * @param productId
     * @return
     */
    List<ProductCatalogPropertyValue> listProductPropertyById(Long productId);
}