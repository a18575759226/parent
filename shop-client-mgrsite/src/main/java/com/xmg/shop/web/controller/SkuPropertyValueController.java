package com.xmg.shop.web.controller;

import com.xmg.shop.domain.SkuProperty;
import com.xmg.shop.domain.SkuPropertyValue;
import com.xmg.shop.service.ISkuPropertyService;
import com.xmg.shop.service.ISkuPropertyValueService;
import com.xmg.shop.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/14.
 */
@Controller
public class SkuPropertyValueController {

    @Autowired
    private ISkuPropertyValueService skuPropertyValueService ;
    @Autowired
    private ISkuPropertyService skuPropertyService ;

    @RequestMapping("getSkuPropertyValue")
    public String SkuPropertyValueList (SkuPropertyValue skuPropertyValue , Model model){
      //  Long id = skuPropertyValue.getId();
       // skuPropertyValue = skuPropertyValueService.selectByPrimaryKey(id);

        List<SkuPropertyValue> valueList = skuPropertyValueService.getSkuProperValue(skuPropertyValue.getSkuPropertyId());
        SkuProperty skuProperty = skuPropertyService.selectByPrimaryKey(skuPropertyValue.getSkuPropertyId());
        model.addAttribute("list",valueList);
        model.addAttribute("skuProperty",skuProperty);

        return "sku/property_value_list";
    }

    /**
     *添加分类属性值
     *
     */
    @RequestMapping("addSkuPropertyValue")
    @ResponseBody
    public AjaxResult addSkuPropertyValue (SkuPropertyValue skuPropertyValue ){
        AjaxResult result = null;
        try {
            skuPropertyValueService.addSkuPropertyValue(skuPropertyValue);

            result = new AjaxResult();
        }catch (Exception e){
            e.printStackTrace();

            result = new AjaxResult(e.getMessage());
        }
        return result;
    }

    @RequestMapping("listSkuPropertyValuesTableById")
    public String listSkuPropertyValuesById(Long id, Model model){
        SkuProperty skuProperty = skuPropertyService.selectByPrimaryKey(id);
        List<SkuPropertyValue> skuPropertyValue = skuPropertyValueService.getSkuProperValue(id);
        model.addAttribute("skuPropertyValue", skuPropertyValue);
        model.addAttribute("skuProperty", skuProperty);
        return "product/sku_property_value_table";
    }

}
