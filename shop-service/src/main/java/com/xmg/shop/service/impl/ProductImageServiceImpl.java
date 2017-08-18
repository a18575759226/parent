package com.xmg.shop.service.impl;

import com.xmg.shop.domain.ProductImage;
import com.xmg.shop.mapper.ProductImageMapper;
import com.xmg.shop.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
@Service
public class ProductImageServiceImpl implements IProductImageService{

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public void insert(ProductImage image) {
        productImageMapper.insert(image);
    }

    /**
     * 根据产品id查询该产品的所有图片
     *
     * @param productId
     * @return
     */
    @Override
    public List<ProductImage> listImagesBrProductId(Long productId) {
        return productImageMapper.listImagesBrProductId(productId);
    }
}
