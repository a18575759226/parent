package com.xmg.shop.vo;

import com.xmg.shop.domain.ProductImage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 * 存储商品相关属性的vo对象
 */
public class ProductVo implements Serializable{

    List<ProductImage> productImages;//商品的相册

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }
}
