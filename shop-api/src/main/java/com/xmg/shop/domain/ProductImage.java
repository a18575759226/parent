package com.xmg.shop.domain;

import java.io.Serializable;

/**
 * 商品相册的实体类
 * 一个对象对应一张图片
 */
public class ProductImage implements Serializable{
    private Long id;

    private Long productId;//对应的商品ID

    private String imagePath;//图片的路径

    private Integer sequence;//图片的编号

    private Long mods=1L;//

    private Byte cover=1;//是否是商品的封面图片 默认值为1  代表不是封面

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getMods() {
        return mods;
    }

    public void setMods(Long mods) {
        this.mods = mods;
    }

    public Byte getCover() {
        return cover;
    }

    public void setCover(Byte cover) {
        this.cover = cover;
    }
}