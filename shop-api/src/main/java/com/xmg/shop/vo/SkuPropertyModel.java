package com.xmg.shop.vo;

import com.xmg.shop.vo.skuProduct.BaseProductSkuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2017/8/17
 */

public class SkuPropertyModel {
    private List<BaseProductSkuVo> productSkuLists = new ArrayList<>();

    public List<BaseProductSkuVo> getProductSkuLists() {
        return productSkuLists;
    }

    public void setProductSkuLists(List<BaseProductSkuVo> productSkuLists) {
        this.productSkuLists = productSkuLists;
    }
}
