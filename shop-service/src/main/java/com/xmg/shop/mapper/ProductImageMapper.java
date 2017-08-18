package com.xmg.shop.mapper;

import com.xmg.shop.domain.ProductImage;
import java.util.List;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductImage record);

    ProductImage selectByPrimaryKey(Long id);

    List<ProductImage> selectAll();

    int updateByPrimaryKey(ProductImage record);

    /**
     * 通过产品id查询该产品的所有图片
     * @param productId
     * @return
     */
    List<ProductImage> listImagesBrProductId(Long productId);
}