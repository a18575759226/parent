package com.xmg.shop.service;

import com.xmg.shop.domain.ProductSku;

import java.util.List;

/**
 * 商品sku服务接口
 *
 * @author dongc
 * @date 2017/8/14
 */
public interface IProductSkuService {

    /**
     * 根据产品id查询产品的sku属性
     * @param productId
     * @return
     */
    List<ProductSku> listProductSkuById(Long productId);

    /**
     * 生成产品sku
     * @param productSkuList
     */
    void productSkuSave(List<ProductSku> productSkuList, Long productId);
}
