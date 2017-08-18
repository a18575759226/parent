package com.xmg.shop.vo.skuProduct;

import com.xmg.shop.vo.SkuPropertyValueVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2017/8/17
 */
@Getter@Setter
public class BaseProductSkuProperty implements Serializable{

    List<SkuPropertyValueVo> productSkuPropertyList = new ArrayList<>();

    public BaseProductSkuProperty() { }
}
