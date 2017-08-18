package com.xmg.shop.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类管理
 */
public class Catalog implements Serializable {
    //id
    private Long id;
    //创建时间
    private Date createDate;
    //上次修改时间
    private Date lastModifiedDate;
    //版本
    private Integer version;
    //水平线
    private Integer level;
    //名称
    private String name;
    //编码
    private String code;
    //顺序
    private Integer sequence;
    //子菜单
    private Integer childrenCatalogs;
    //商品
    private Integer products;
    //父级菜单id
    private Long parentCatalogId;
    //顶级分类
    private Byte isParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getChildrenCatalogs() {
        return childrenCatalogs;
    }

    public void setChildrenCatalogs(Integer childrenCatalogs) {
        this.childrenCatalogs = childrenCatalogs;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }

    public Long getParentCatalogId() {
        return parentCatalogId;
    }

    public void setParentCatalogId(Long parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
    }

    public Byte getIsParent() {
        return isParent;
    }

    public void setIsParent(Byte isParent) {
        this.isParent = isParent;
    }
}