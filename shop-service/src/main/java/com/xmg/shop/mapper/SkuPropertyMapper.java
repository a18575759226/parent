package com.xmg.shop.mapper;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.SkuProperty;
import com.xmg.shop.query.QueryObject;

import java.util.List;

public interface SkuPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuProperty record);

    SkuProperty selectByPrimaryKey(Long id);

    List<SkuProperty> selectAll();

    int updateByPrimaryKey(SkuProperty record);

    Long count(QueryObject qo);

    List<Product> queryPage(QueryObject qo);

    /**
     * 根据产品分类查询该分类的sku
     * @param id
     * @return
     */
    List<SkuProperty> listSkusByProductCatlog(Long id);

    /**
     *
     * 根据分类查询sku
     * @param catalogId
     * @return
     */
    List<SkuProperty> getSkuProperty(Long catalogId);
}