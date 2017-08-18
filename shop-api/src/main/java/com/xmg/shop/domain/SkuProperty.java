package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by JINZHAOYU on 2017/8/14.
 */
@Getter@Setter
public class SkuProperty implements Serializable {

    public static final int TEXT = 0 ;//输入框

    public static final int checkbox = 1 ;//多选框

    public static final int  DROP_DOWN_BOX = 2 ;//下拉框

    private Long id ;

    private String name ;//sku属性名称


    private Long  catalogId ;//sku所属分类

    private int type ;//该商品分类所属类型

    private int  sequence ;//排序


    public String getPropertyType(){

       switch (type){
           case TEXT :
               return "输入框";
           case checkbox:
               return "多选框";
           case  DROP_DOWN_BOX:
               return  "下拉框";
           default:
               return "";
       }
    }
}
