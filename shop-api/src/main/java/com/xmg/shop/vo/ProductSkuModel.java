package com.xmg.shop.vo;

import com.xmg.shop.domain.ProductSku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2017/8/17
 */
public class ProductSkuModel implements Serializable{

    List<ProductSku> productSku = new ArrayList<>();

    public ProductSkuModel() {
    }

    public ProductSkuModel(List<ProductSku> productSku) {
        this.productSku = productSku;
    }

    public List<ProductSku> getProductSku() {
        return productSku;
    }

    public void setProductSku(List<ProductSku> productSku) {
        this.productSku = productSku;
    }
}
