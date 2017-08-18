package com.xmg.shop.domain;

import java.io.Serializable;

public class ProductDesc implements Serializable{
    private Long id;

    private Long productId;//对应的商品的id

    private String details;//商品详情字段

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDetails() {
        return details==null?"":details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}