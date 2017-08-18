package com.xmg.shop.mapper;

import com.xmg.shop.domain.ProductSku;
import java.util.List;

public interface ProductSkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductSku record);

    ProductSku selectByPrimaryKey(Long id);

    List<ProductSku> selectAll();

    int updateByPrimaryKey(ProductSku record);

    /**
     * 根据产品id查询产品的sku属性
     * @param productId
     * @return
     */
    List<ProductSku> listProductSkuById(Long productId);

    /**
     * 通过产品id删除该商品的所有sku属性
     * @param productId
     */
    void deleteByProductId(Long productId);
}