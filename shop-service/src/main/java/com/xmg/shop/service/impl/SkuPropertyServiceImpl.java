package com.xmg.shop.service.impl;

import com.xmg.shop.domain.Product;
import com.xmg.shop.domain.SkuProperty;
import com.xmg.shop.domain.SkuPropertyValue;
import com.xmg.shop.mapper.CatalogMapper;
import com.xmg.shop.mapper.SkuPropertyMapper;
import com.xmg.shop.mapper.SkuPropertyValueMapper;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.SkuPropertyQueryObject;
import com.xmg.shop.service.ISkuPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/13.
 */
@Service
public class SkuPropertyServiceImpl implements ISkuPropertyService {

    @Autowired
    private SkuPropertyMapper skuPropertyMapper;
    @Autowired
    private SkuPropertyValueMapper skuPropertyValueMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(SkuProperty record) {
        return 0;
    }

    @Override
    public SkuProperty selectByPrimaryKey(Long id) {
        return skuPropertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SkuProperty> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(SkuProperty record) {
        return 0;
    }

    @Override
    public PageResult query(SkuPropertyQueryObject qo) {

        Long count = skuPropertyMapper.count(qo);

        if (count == 0) {
            return PageResult.empty(qo.getPageSize());
        }
        List<Product> listData = skuPropertyMapper.queryPage(qo);
        return new PageResult(listData, count.intValue(), qo.getCurrentPage(), qo.getPageSize());
    }

    @Override
    public List<TreeNode> getTreeNodes(String parentId) {

        return null;
    }

    /**
     * 根据产品分类查询该分类的
     *
     * @param id
     * @return
     */
    @Override
    public List<SkuProperty> listSkusByProductCatlog(Long id) {
        return skuPropertyMapper.listSkusByProductCatlog(id);
    }

    @Override
    public List<SkuProperty> getSkuProperty(Long catalogId) {

        return skuPropertyMapper.getSkuProperty(catalogId);

    }

    @Override
    public void saveOrUpdate(SkuProperty skuProperty) {
        Long id = skuProperty.getId();
        if (id!=null){
            skuPropertyMapper.updateByPrimaryKey(skuProperty);
        }else{
            skuPropertyMapper.insert(skuProperty);
        }
    }

    @Override
    public void delect(Long id) {
        //先删除关联的外键
        List<SkuPropertyValue> skuProperValueList = skuPropertyValueMapper.getSkuProperValue(id);
        for (SkuPropertyValue skuPropertyValue : skuProperValueList) {
            skuPropertyValueMapper.deleteByPrimaryKey(skuPropertyValue.getId());
        }

        skuPropertyMapper.deleteByPrimaryKey(id);
    }
}