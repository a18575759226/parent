package com.xmg.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author
 * @date 2017/8/15
 */
@Getter@Setter@ToString
public class SkuPropertyValueVo implements Serializable {
    private String value;
    private SkuPropertyVo skuProperty;

    public SkuPropertyValueVo() {
    }
}
