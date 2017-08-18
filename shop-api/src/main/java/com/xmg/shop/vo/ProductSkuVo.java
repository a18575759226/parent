package com.xmg.shop.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * @date 2017/8/15
 */
@Getter@Setter
public class ProductSkuVo implements Serializable{
    private volatile Long productId;
    private List<SkuPropertyVo> skuPropertiesList = new ArrayList<>();
    private List<SkuPropertyValueVo> skuPropertyValueList = new ArrayList<>();
}
