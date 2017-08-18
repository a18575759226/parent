package com.xmg.shop.service.impl;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.ProductSku;
import com.xmg.shop.mapper.ProductSkuMapper;
import com.xmg.shop.service.IProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 商品sku业务实现类
 * @author
 * @date 2017/8/14
 */
public class ProductSkuServiceImpl implements IProductSkuService{
    @Autowired
    private ProductSkuMapper productSkuMapper;
    /**
     * 根据产品id查询产品的sku属性
     *
     * @param productId
     * @return
     */
    @Override
    public List<ProductSku> listProductSkuById(Long productId) {
        return productSkuMapper.listProductSkuById(productId);
    }

    /**
     * 生成产品sku
     * @param productSkuList
     * @param productId
     */
    @Override
    public void productSkuSave(List<ProductSku> productSkuList, Long productId) {
            //通过id查询产品sku表中该商品是否已经生成过sku
            List<ProductSku> temp = productSkuMapper.listProductSkuById(productId);
            //if (temp != null && temp.size() > 0) {//如果已经有sku,先删除sku
            //    productSkuMapper.deleteByProductId(productId);
            //}
            //插入数据
            ProductSku item = null;
            Product product = new Product();
            product.setId(productId);
            for (ProductSku productSku : productSkuList) {
                if (productSku.getCode() != null && productSku.getPrice() != null){
                    item.setProduct(product);
                    item.setCode(productSku.getCode());
                    item.setPrice(productSku.getPrice());
                    item.setMods(1L);
                    productSkuMapper.insert(item);
                }
            }
    }
}
