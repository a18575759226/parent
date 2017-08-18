package com.xmg.shop.service;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.ProductCatalogPropertyValue;
import com.xmg.shop.domain.ProductDesc;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.ProductQueryObject;
import com.xmg.shop.vo.ProductSkuVo;
import com.xmg.shop.vo.ProductVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 商品的业务接口
 * @author dongc
 * @date 2017/8/11
 */
public interface IProductService {
    /**
     * 通过id获取产品信息
     * @param id 产品id
     * @return
     */
    Product get(Long id);

    /**
     * 商品的保存操作
     * @param product
     * @param productDesc 前台传进来的商品详情
     */
    void productSave(Product product, ProductDesc productDesc,ProductVo productVo);

    PageResult pageResult(ProductQueryObject qo);

    /**
     * 通过产品id获取所有的属性
     * @param productId 产品id
     * @return
     */
    List<ProductCatalogPropertyValue> listProductPropertyById(Long productId);

    /**
     * 更新产品信息
     * @param product
     */
    void update(Product product);

    /**
     * 上传商品文件
     * @param file 需要上传的文件
     * @return 上传后文件的路径
     */
    String uploadImg(MultipartFile file);

    /**
     * 生成商品sku
     * @param vo
     */
    void generateSkuList(ProductSkuVo vo);


}
