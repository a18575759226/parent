package com.xmg.shop.domain;

import java.io.Serializable;

public class CatalogProperty implements Serializable {
    //ID
    private Long id;
    //分类菜单ID
    private Long catalogId;
    //名称
    private String name;
    //序列
    private Integer sequence;
    //类型
    private Byte type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}