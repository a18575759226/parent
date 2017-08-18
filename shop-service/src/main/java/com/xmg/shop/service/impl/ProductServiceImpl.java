package com.xmg.shop.service.impl;

import com.xmg.shop.domain.*;
import com.xmg.shop.mapper.ProductMapper;
import com.xmg.shop.mapper.ProductSkuMapper;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.ProductQueryObject;
import com.xmg.shop.service.IProductDescService;
import com.xmg.shop.service.IProductImageService;
import com.xmg.shop.service.IProductService;
import com.xmg.shop.util.UploadUtil;
import com.xmg.shop.vo.ProductSkuVo;
import com.xmg.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2017/8/11
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private IProductDescService productDescService;

    @Autowired
    private IProductImageService productImageService;
    @Autowired
    private ServletContext ctx;

    //private

    /**
     * 通过id获取产品信息
     *
     * @param id 产品id
     * @return
     */
    @Override
    public Product get(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult pageResult(ProductQueryObject qo) {
        Long count = productMapper.count(qo);
        if (count == 0) {
            return PageResult.empty(qo.getPageSize());
        }
        List<Product> listData = productMapper.queryPage(qo);
        return new PageResult(listData, count.intValue(), qo.getCurrentPage(), qo.getPageSize());
    }

    /**
     * 通过产品id获取所有的属性
     *
     * @param productId 产品id
     * @return
     */
    @Override
    public List<ProductCatalogPropertyValue> listProductPropertyById(Long productId) {
        return productMapper.listProductPropertyById(productId);
    }



    /**
     * 更新产品信息
     *
     * @param product
     */
    @Override
    public void update(Product product) {
        Product temp = productMapper.selectByPrimaryKey(product.getId());
        if (temp.getImage() != null && !temp.getImage().equals(product.getImage())) {
            UploadUtil.deleteFile(temp.getImage());
        }
        temp.setImage(product.getImage());
        temp.setName(product.getName());
        temp.setMods(product.getMods());
        temp.setMarketPrice(product.getMarketPrice());
        temp.setKeyword(product.getKeyword());
        temp.setImpressions(product.getImpressions());
        temp.setLastModifiedDate(new Date());
        temp.setCode(product.getCode());
        temp.setCatalog(product.getCatalog());
        temp.setBasePrice(product.getBasePrice());
        temp.setProductBrand(product.getProductBrand());
        productMapper.updateByPrimaryKey(temp);
    }

    /**
     * 上传商品文件
     *
     * @param file 需要上传的文件
     * @return 上传后文件的路径
     */
    @Override
    public String uploadImg(MultipartFile file) {
        String realName = UploadUtil.upload(file, ctx.getRealPath("/upload"));
        return "/upload/" + realName;
    }

    /**
     * 商品的保存操作
     *
     * @param product
     * @param productDesc 前台传进来的商品详情
     */
    @Override
    public void productSave(Product product, ProductDesc productDesc, ProductVo productVo) {
        Product pd = new Product();
        pd.setBasePrice(product.getBasePrice());
        pd.setCode(product.getCode());
        pd.setCreatedDate(new Date());
//        pd.setImage(product.getImage());
        pd.setImpressions(product.getImpressions());
        pd.setKeyword(product.getKeyword());
        pd.setLastModifiedDate(new Date());
        pd.setName(product.getName());
        pd.setMarketPrice(product.getMarketPrice());
//        pd.setProductBrand(product.getProductBrand());
//        pd.setMods(product.getMods());

        //首先将封装好的商品对象保存进数据库获取到生成的id
        productMapper.insert(pd);
        Long productId = pd.getId();
        //为商品详情对象设置商品id
        ProductDesc desc = new ProductDesc();
        desc.setProductId(pd.getId());
        desc.setProductId(productId);
        productDescService.insert(desc);

        //遍历传进来的相册对象保存进数据库
        List<ProductImage> productImages = productVo.getProductImages();
        for (ProductImage productImage : productImages) {
            if (productImage.getImagePath() != null) {
                ProductImage image = new ProductImage();
                image.setImagePath(productImage.getImagePath());
                image.setProductId(productId);
                image.setSequence(productImage.getSequence());
                image.setCover(productImage.getCover());
                productImageService.insert(image);
            }
        }
    }

    /**
     * 生成商品sku
     *
     * @param vo
     */
    @Override
    public void generateSkuList(ProductSkuVo vo) {
        Long productId = vo.getProductId();
    }

}
