package com.xmg.shop.web.controller;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.ProductDesc;
import com.xmg.shop.service.IProductService;
import com.xmg.shop.util.AjaxResult;
import com.xmg.shop.util.UploadUtil;
import com.xmg.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

/**
 * Created by Administrator on 2017/8/13 0013.
 * 后台商品录入的控制类
 */
@Controller
public class ProductAddController {

    @Autowired
    private ServletContext ctx;
    @Autowired
    private IProductService productService;

    @RequestMapping("addProduct")
    public String addProduct(){
        return "/product/product_input";
    }

    @RequestMapping("productSave")
    @ResponseBody
    public AjaxResult productSave(Product product, ProductDesc productDesc, ProductVo productVo){
        productService.productSave(product,productDesc,productVo);
        return new AjaxResult();
    }

    /**
     * 商品录入的图片上传操作
     */
    @RequestMapping("productImgUpload")
    @ResponseBody
    public String realAuthUpload(MultipartFile file){
        String realName = UploadUtil.upload(file, ctx.getRealPath("/upload"));
        System.out.println(realName);
        return "/upload/"+realName;
    }
}
