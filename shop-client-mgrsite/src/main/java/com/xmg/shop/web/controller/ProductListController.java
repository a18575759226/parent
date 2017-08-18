package com.xmg.shop.web.controller;

import com.xmg.shop.domain.*;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.ProductQueryObject;
import com.xmg.shop.service.*;
import com.xmg.shop.util.AjaxResult;
import com.xmg.shop.util.CalculatorUtil;
import com.xmg.shop.vo.ProductSkuModel;
import com.xmg.shop.vo.ProductSkuVo;
import com.xmg.shop.vo.SkuPropertyValueVo;
import com.xmg.shop.vo.SkuPropertyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品列表控制器
 *
 * @author dongc
 * @date 2017/8/13
 */
@Controller
public class ProductListController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductDescService productDescService;
    @Autowired
    private IProductImageService productImageService;
    @Autowired
    private IProductSkuService productSkuService;
    @Autowired
    private ISkuPropertyService skuPropertyService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private ICatalogService catalogService;
    /**
     * 商品列表
     *
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("/productList")
    public String productList(@ModelAttribute("qo") ProductQueryObject qo, Model model, HttpSession session) {
        //商品列表数据
        PageResult pageResult = productService.pageResult(qo);
        //所有的品牌
        List<Brand> brands = brandService.selectAll();
        //所有的分类信息
        List<Catalog> catalogs = catalogService.selectAll();
        model.addAttribute("pageResult", pageResult);
        model.addAttribute("brands", brands);
        model.addAttribute("catalogs", catalogs);
        model.addAttribute("sessionid", session.getId());
        return "product/product_list";
    }

    /**
     * 展示商品详细信息
     *
     * @param productId 产品id
     * @param model
     * @return
     */
    @RequestMapping("/showProduct")
    public String showProduct(Long productId, Model model) {
        //商品基本信息
        Product product = productService.get(productId);
        //商品详情
        ProductDesc productDesc = productDescService.get(productId);
        //商品属性
        List<ProductCatalogPropertyValue> propertyList = productService.listProductPropertyById(productId);
        //商品相册
        List<ProductImage> productImageList= productImageService.listImagesBrProductId(productId);
        //根据产品分类查询产品的sku
        List<SkuProperty> skuPropertyList = skuPropertyService.listSkusByProductCatlog(product.getCatalog().getId());
        //根据产品id获取sku属性
        List<ProductSku> productSkuList = productSkuService.listProductSkuById(productId);
        //productSkuList
        model.addAttribute("product", product);
        model.addAttribute("productDesc", productDesc);
        model.addAttribute("propertyList", propertyList);
        model.addAttribute("productImageList", productImageList);
        model.addAttribute("skuPropertyList", skuPropertyList);
        model.addAttribute("productSkuList", productSkuList);
        return "product/show_product";
    }


    @RequestMapping("/getProductJson")
    @ResponseBody
    public String getProductJson(Long productId){
        Product product = productService.get(productId);
        System.out.println(product.getJson());
        return product.getJson();
    }

    @RequestMapping("/updateProduct")
    @ResponseBody
    public AjaxResult updateProduct(Product product){
        AjaxResult result = null;
        try {
            productService.update(product);
            result = new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("商品更改异常,请联系管理员");
        }
        return result;
    }

    /**
     * 跳转到商品生成SKU界面
     *
     * @param productId 产品id
     * @return
     */
    @RequestMapping("/toGenerateSkuUI")
    public String toGenerateSkuUI(Long productId, Model model) {
        //商品基本信息
        Product product = productService.get(productId);
        //根据产品分类查询产品的sku
        List<SkuProperty> skuPropertyList = skuPropertyService.listSkusByProductCatlog(product.getCatalog().getId());
        //根据产品id获取sku属性
        List<ProductSku> productSkuList = productSkuService.listProductSkuById(productId);
        //productSkuList
        model.addAttribute("product", product);
        model.addAttribute("skuPropertyList", skuPropertyList);
        model.addAttribute("productSkuList", productSkuList);
        return "product/sku_generate";
    }

    /**
     * 生成商品sku
     * @return
     */
    @RequestMapping("/generateSkuList")
    public String generateSkuList(@RequestBody ProductSkuVo vo, Model model){
        List<SkuPropertyVo> skuPropertieList = vo.getSkuPropertiesList();
        List<String> skuPropertieName = new ArrayList<>();
        for (SkuPropertyVo skuPropertyVo : skuPropertieList) {
            skuPropertieName.add(skuPropertyVo.getName());
        }
        List<Map<String,Object>> skuList = new ArrayList<>();
        //int index = 0;
        List<SkuPropertyValueVo> skuPropertyValueList = vo.getSkuPropertyValueList();
        //得到
        List<List<String>> result = new ArrayList<>();
        SkuPropertyValueVo spvv = new SkuPropertyValueVo();
        for (int i = 0; i < skuPropertieList.size(); i++) {
            spvv.setSkuProperty(skuPropertieList.get(i));
            List<String> ele = new ArrayList<>();
            for (SkuPropertyValueVo sp : skuPropertyValueList) {
                if(spvv.getSkuProperty().getId().equals(sp.getSkuProperty().getId())){
                    ele.add(sp.getValue());
                }
            }
            result.add(ele);
        }
        List<List<String>> ret = CalculatorUtil.circulate(result);//获取sku的笛卡尔集
        //商品价格
        BigDecimal productPrice = productService.get(vo.getProductId()).getBasePrice();
        for (List<String> list : ret) {
            Map<String, Object> map = new LinkedHashMap<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() ; i ++) {
                String s = list.get(i);
                //proList.add(s);
                map.put(skuPropertieName.get(i),s);
                sb.append(s).append("/");
            }
            map.put("code", sb.deleteCharAt(sb.length() - 1));
            map.put("price", productPrice);
            skuList.add(map);
        }
        model.addAttribute("skuPropertieList", skuPropertieList);
        model.addAttribute("skuList", skuList);
        model.addAttribute("ProductSkuVo", vo);
        return "product/sku_form";
    }

    @RequestMapping("/productSkuSave.do")
    @ResponseBody
    public AjaxResult productSkuSave(ProductSkuModel productSku, Long productId){
        AjaxResult result = null;
        List<ProductSku> productSkuList = productSku.getProductSku();
        try {
            productSkuService.productSkuSave(productSkuList,productId);
            result = new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("操作失败,请联系管理员");
        }
        return result;
    }
}