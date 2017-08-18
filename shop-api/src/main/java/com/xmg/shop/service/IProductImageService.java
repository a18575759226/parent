package com.xmg.shop.service;

import com.xmg.shop.domain.ProductImage;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 * 商品相册的service接口
 */
public interface IProductImageService {

    void insert(ProductImage image);

    /**
     * 根据产品id查询该产品的所有图片
     * @param productId
     * @return
     */
    List<ProductImage> listImagesBrProductId(Long productId);
}
