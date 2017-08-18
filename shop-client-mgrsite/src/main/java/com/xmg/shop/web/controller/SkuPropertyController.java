package com.xmg.shop.web.controller;

import com.xmg.shop.domain.SkuProperty;
import com.xmg.shop.service.ISkuPropertyService;
import com.xmg.shop.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * sku后台控制器
 * Created by JINZHAOYU on 2017/8/13.
 */
@Controller
public class SkuPropertyController {

    @Autowired
    private ISkuPropertyService skuPropertyService;

    @RequestMapping("skuProperty")
    public String skuPropertyList() {

        return "sku/property";
    }

    ;


    /**
     * sku列表
     *
     * @param model
     * @param catalogId
     * @return
     */
    @RequestMapping("getSkuProperty")
    public String skuList(Model model, Long catalogId) {

        List<SkuProperty> list = skuPropertyService.getSkuProperty(catalogId);
        model.addAttribute("list", list);
        return "sku/property_list";
    }

    /**
     * 编辑模态框
     *
     * @param id
     * @param catalogId
     * @param model
     * @return
     */
    @RequestMapping("toSkuPropertySave")
    public String updateModel(SkuProperty skuProperty, Long catalogId, Model model) {
        if (skuProperty.getId() != -1) {
            skuProperty = skuPropertyService.selectByPrimaryKey(skuProperty.getId());
        }
        model.addAttribute("skuProperty", skuProperty);
        return "sku/property_save";
    }

    /**
     * 编辑以及保存
     *
     * @param skuProperty
     * @return
     */
    @RequestMapping("addSkuProperty")
    @ResponseBody
    public AjaxResult saveOrUpdate(SkuProperty skuProperty) {
        AjaxResult result = null;
        try {
            skuPropertyService.saveOrUpdate(skuProperty);
            result = new AjaxResult();
        } catch (Exception e) {
            result = new AjaxResult(e.getMessage());
        }

        return result;
    }

    @RequestMapping("deleteSkuProperty")
    public String delect(Long id, Long catalogId) {

        skuPropertyService.delect(id);

        return "redirect:/getSkuProperty.do?catalogId="+catalogId;


    }
}