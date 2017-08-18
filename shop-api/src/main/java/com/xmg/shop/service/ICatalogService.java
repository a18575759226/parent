package com.xmg.shop.service;

import com.xmg.shop.domain.Catalog;

import java.util.List;

/**
 * Created by asus on 2017/08/13.
 */
public interface ICatalogService {
    int deleteByPrimaryKey(Long id);

    int insert(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

    List<Catalog> getChildrenCatalogsById(Long parentId);
}
