package com.xmg.shop.vo.skuProduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2017/8/17
 */
public class BaseProductSkuVo implements Serializable {

    private List<BaseProductSkuProperty> productSkuPropertyList = new ArrayList<>();

    public BaseProductSkuVo() { }

    public List<BaseProductSkuProperty> getProductSkuPropertyList() {
        return productSkuPropertyList;
    }

    public void setProductSkuPropertyList(List<BaseProductSkuProperty> productSkuPropertyList) {
        this.productSkuPropertyList = productSkuPropertyList;
    }
}
