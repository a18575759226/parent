package com.xmg.shop.service.impl;

import com.xmg.shop.domain.Catalog;
import com.xmg.shop.mapper.CatalogMapper;
import com.xmg.shop.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/08/13.
 */
@Service
public class CatalogServiceImpl implements ICatalogService {

    @Autowired
    CatalogMapper catalogMapper;

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return catalogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加菜单
     *
     * @param record
     * @return
     */
    @Override
    public int insert(Catalog record) {
        record.setCreateDate(new Date());
        record.setIsParent(Byte.valueOf("0"));
        record.setLastModifiedDate(new Date());
        record.setVersion(0);
        record.setSequence(1);
        Catalog catalog = catalogMapper.selectByPrimaryKey(record.getParentCatalogId());
        catalog.setIsParent(Byte.valueOf("1"));
        catalogMapper.updateByPrimaryKey(catalog);
        return catalogMapper.insert(record);
    }

    /**
     * 通过Id查询
     *
     * @param id
     * @return
     */
    @Override
    public Catalog selectByPrimaryKey(Long id) {
        return catalogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Catalog> selectAll() {
        return catalogMapper.selectAll();
    }

    /**
     * 修改
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Catalog record) {
        return catalogMapper.updateByPrimaryKey(record);
    }

    /**
     * 通过id查询子分类
     *
     * @param parentId
     * @return
     */
    @Override
    public List<Catalog> getChildrenCatalogsById(Long parentId) {
        return catalogMapper.getChildrenCatalogsById(parentId);
    }
}
