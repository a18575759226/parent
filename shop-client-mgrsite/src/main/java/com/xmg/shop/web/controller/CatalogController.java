package com.xmg.shop.web.controller;

import com.xmg.shop.domain.Catalog;
import com.xmg.shop.service.ICatalogService;
import com.xmg.shop.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/08/13.
 */

/**
 * 分类管理
 */
@Controller
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @RequestMapping("catalog.do")
    public String catalog(Model model) {
        return "catalog/catalog";
    }

    /**
     * 添加分类
     *
     * @param catalog
     */
    @ResponseBody
    @RequestMapping("catalogSave.do")
    public AjaxResult catalogsave(Catalog catalog) {
        AjaxResult result = new AjaxResult();
        try {
            if (catalog.getId() == null) {
                catalogService.insert(catalog);
            } else {
                Catalog primaryKey = catalogService.selectByPrimaryKey(catalog.getId());
                primaryKey.setCode(catalog.getCode());
                primaryKey.setName(catalog.getName());
                primaryKey.setLastModifiedDate(new Date());
                catalogService.updateByPrimaryKey(primaryKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询分类
     *
     * @param id
     * @return
     */
    @RequestMapping("getCatalog.do")
    @ResponseBody
    public List<Catalog> getCatalog(Long id) {
        List<Catalog> list = catalogService.getChildrenCatalogsById(id);
        return list;
    }

    /**
     * 进入遍历界面
     *
     * @param model
     * @param catalogId
     * @return
     */
    @RequestMapping("catalogInput.do")
    public String catalogInpl(Model model, Long catalogId) {
        Catalog catalog = catalogService.selectByPrimaryKey(catalogId);
        model.addAttribute("catalog", catalog);
        return "catalog/catalog_input";
    }

    /**
     * 分类删除操作
     *
     * @param catalogId
     * @return
     */
    @RequestMapping("deleteCatalog.do")
    @ResponseBody
    public AjaxResult deleteCatalog(Long catalogId) {
        AjaxResult result = null;
        try {
            catalogService.deleteByPrimaryKey(catalogId);
            result = new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(e.getMessage());
        }

        return result;
    }
}
