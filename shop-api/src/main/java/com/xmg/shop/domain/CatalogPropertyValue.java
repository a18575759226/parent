package com.xmg.shop.domain;

import java.io.Serializable;

public class CatalogPropertyValue implements Serializable {

    //id
    private Long id;

    //菜单属性id
    private CatalogProperty catalogProperty;
    //值
    private String value;
    //序列
    private Integer sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatalogProperty getCatalogProperty() {
        return catalogProperty;
    }

    public void setCatalogProperty(CatalogProperty catalogProperty) {
        this.catalogProperty = catalogProperty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}