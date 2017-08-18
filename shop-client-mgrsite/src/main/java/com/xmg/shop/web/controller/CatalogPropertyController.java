package com.xmg.shop.web.controller;

import com.xmg.shop.domain.CatalogProperty;
import com.xmg.shop.domain.CatalogPropertyValue;
import com.xmg.shop.service.ICatalogPropertyService;
import com.xmg.shop.service.ICatalogPropertyValueService;
import com.xmg.shop.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by asus on 2017/08/14.
 */
@Controller
public class CatalogPropertyController {

    @Autowired
    ICatalogPropertyService catalogPropertyService;
    @Autowired
    ICatalogPropertyValueService catalogPropertyValueService;

    /**
     * 进入分类属性界
     *
     * @return
     */
    @RequestMapping("catalogProperty.do")
    public String catalogProperty() {
        return "property/property";
    }

    /**
     * 通过id获取分类属性,返回属性列表
     *
     * @param model
     * @param catalogId
     * @return
     */
    @RequestMapping("getCatalogProperty.do")
    public String getCatalogProperty(Model model, Long catalogId) {
        List<CatalogProperty> list = catalogPropertyService.getCatalogProperty(catalogId);
        model.addAttribute("list", list);
        return "property/property_list";
    }


    /**
     * 分类属性添加
     *
     * @param catalogProperty
     * @return
     */
    @RequestMapping("addCatalogProperty.do")
    @ResponseBody
    public AjaxResult addCatalogProperty(CatalogProperty catalogProperty) {
        AjaxResult result = new AjaxResult();
        try {
            if (catalogProperty.getId() == null || catalogProperty.getId() == -1) {
                catalogProperty.setSequence(0);
                catalogPropertyService.insert(catalogProperty);
            } else {
                CatalogProperty primaryKey = catalogPropertyService.selectByPrimaryKey(catalogProperty.getId());
                primaryKey.setName(catalogProperty.getName());
                primaryKey.setType(catalogProperty.getType());
                catalogPropertyService.updateByPrimaryKey(primaryKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分类属性值的删除方法
     *
     * @return
     */
    @RequestMapping("deleteCatalogPropertyValue.do")
    @ResponseBody
    public AjaxResult deleteCatalogPropertyValue(Long catalogPropertyId) {
        AjaxResult result = new AjaxResult();
        try {
            catalogPropertyValueService.deleteByPrimaryKey(catalogPropertyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分类属性值的添加方法
     *
     * @param catalogPropertyValue
     * @return
     */
    @RequestMapping("addCatalogPropertyValue.do")
    @ResponseBody
    public AjaxResult addCatalogPropertyValue(CatalogPropertyValue catalogPropertyValue) {
        AjaxResult result = new AjaxResult();
        try {
            catalogPropertyValue.setSequence(0);
            catalogPropertyValue.setCatalogProperty(catalogPropertyValue.getCatalogProperty());
            catalogPropertyValueService.insert(catalogPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 在哪个分类上添加属性
     *
     * @param catalogProperty
     * @param model
     * @return
     */
    @RequestMapping("toPropertySave.do")
    public String toPropertySave(CatalogProperty catalogProperty, Model model) {

        if (catalogProperty.getId() != null && catalogProperty.getId() != -1) {
            catalogProperty = catalogPropertyService.selectByPrimaryKey(catalogProperty.getId());
        }
        model.addAttribute("catalogProperty", catalogProperty);
        return "property/property_save";
    }

    /**
     * 删除分类属性
     *
     * @return
     */
    @RequestMapping("deleteCatalogProperty.do")
    public String deleteCatalogProperty(CatalogProperty catalogProperty) {
        catalogPropertyService.deleteByPrimaryKey(catalogProperty.getId());
        return "redirect:/getCatalogProperty.do?catalogId=" + catalogProperty.getCatalogId();
    }

    /**
     * 通过分类属性id查看分类属性值
     *
     * @param model
     * @param catalogPropertyId
     * @return
     */
    @RequestMapping("getCatalogPropertyValue.do")
    public String getCatalogPropertyValue(Model model, Long catalogPropertyId) {
        try {
            CatalogProperty catalog = catalogPropertyService.selectByPrimaryKey(catalogPropertyId);
            List<CatalogPropertyValue> propertyValue = catalogPropertyService.getCatalogPropertyValue(catalogPropertyId);
            model.addAttribute("list", propertyValue);
            model.addAttribute("catalogProperty", catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "property/property_value_list";
    }


}

