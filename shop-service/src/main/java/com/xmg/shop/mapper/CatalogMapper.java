package com.xmg.shop.mapper;


import com.xmg.shop.domain.Catalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

    List<Catalog> getChildrenCatalogsById(@Param("parentId") Long parentId);
}