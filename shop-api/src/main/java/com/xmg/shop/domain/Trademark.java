package com.xmg.shop.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/8/14.
 */
public class Trademark implements Serializable {


    public static final int SHOW = 0;//显示
    public static final int NO_SHOW = 1;//不显示
    private Long id;
    private String name;//中文名字
    private String englishName;//品牌英文名
    private String url;//地址
    private String img;//图片
    private String describe;//备注
    private int sort=-1;//排序
    private int state=-1;//是否显示

    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("englishName", englishName);
        map.put("url", url);
        map.put("img", img);
        map.put("describe", describe);
        map.put("sort", sort);
        map.put("state", state);
        return JSON.toJSONString(map);
    }
    public String getStateDisplay(){
        switch (state){
            case SHOW:
                return "显示";
            case  NO_SHOW:
                return "不显示";
            default:return "";
        }
    }

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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
