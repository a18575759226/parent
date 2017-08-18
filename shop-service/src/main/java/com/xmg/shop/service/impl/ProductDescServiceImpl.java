package com.xmg.shop.service.impl;

import com.xmg.shop.domain.ProductDesc;
import com.xmg.shop.mapper.ProductDescMapper;
import com.xmg.shop.service.IProductDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/13 0013.
 */
@Service
public class ProductDescServiceImpl implements IProductDescService {

    @Autowired
    private ProductDescMapper productDescMapper;

    @Override
    public void insert(ProductDesc record) {
        productDescMapper.insert(record);
    }

    @Override
    public ProductDesc get(Long id) {
        return productDescMapper.selectByPrimaryKey(id);
    }
}
