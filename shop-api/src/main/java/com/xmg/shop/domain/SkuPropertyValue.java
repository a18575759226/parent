package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * SKU可选属性值表
 */
@Getter@Setter
public class SkuPropertyValue  implements Serializable {
    private Long id;

    private Long  skuPropertyId;

    private String value;

    private Integer sequence;


}