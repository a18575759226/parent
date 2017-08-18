package com.xmg.shop.domain;

import com.alibaba.fastjson.JSON;
import com.xmg.shop.util.DateUtil;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class Product implements Serializable{
    private Long id;//主键id,自增长

    private Date createdDate;//创建时间

    private Date lastModifiedDate;//最近修改时间

    private Integer version;//版本

    private Catalog catalog;//产品分类

    private Brand productBrand;//产品品牌

    private String name;//品牌名字

    private String keyword;//关键字

    private String code;//品牌编码

    private String image;//图片

    private BigDecimal marketPrice;//市场价

    private BigDecimal basePrice;//(基本)成本价

    private Long mods;

    private String impressions;//商品标签

    public String getJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("createdDate", DateUtil.format(createdDate));
        map.put("lastModifiedDate", DateUtil.format(lastModifiedDate));
        map.put("catalog", this.getCatalog().getId());
        map.put("productBrand", this.getProductBrand().getId());
        map.put("name", name);
        map.put("keyword", keyword);
        map.put("code", code);
        map.put("image", image);
        map.put("marketPrice", marketPrice);
        map.put("basePrice", basePrice);
        map.put("mods", mods);
        map.put("impressions", impressions);
        return JSON.toJSONString(map);
    }


    public String getCatalogName(){
        if (this.getCatalog() == null){
            return "";
        }
        return this.getCatalog().getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public void setMods(Long mods) {
        this.mods = mods;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }


}