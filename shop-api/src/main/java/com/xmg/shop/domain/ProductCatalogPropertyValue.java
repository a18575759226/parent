package com.xmg.shop.domain;

import java.io.Serializable;

/**
 * 商品属性
 */
public class ProductCatalogPropertyValue implements Serializable{
    private Long id;//商品属性id,自增长

    private String name;//属性名称

    private String value;//属性值

    private Product product;//属性所属品牌

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}