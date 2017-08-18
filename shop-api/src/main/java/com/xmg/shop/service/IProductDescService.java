package com.xmg.shop.service;

import com.xmg.shop.domain.ProductDesc;

/**
 * Created by Administrator on 2017/8/13 0013.
 * 商品详情的service接口
 */
public interface IProductDescService {

    void insert(ProductDesc record);

    ProductDesc get(Long id);
}
