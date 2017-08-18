package com.xmg.shop.service.impl;

import com.xmg.shop.domain.CatalogProperty;
import com.xmg.shop.domain.CatalogPropertyValue;
import com.xmg.shop.mapper.CatalogPropertyMapper;
import com.xmg.shop.mapper.CatalogPropertyValueMapper;
import com.xmg.shop.service.ICatalogPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/08/14.
 */
@Service
public class CatalogPropertyServiceImpl implements ICatalogPropertyService {

    @Autowired
    private CatalogPropertyMapper catalogPropertyMapper;

    @Autowired
    private CatalogPropertyValueMapper catalogPropertyValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return catalogPropertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CatalogProperty record) {
        return catalogPropertyMapper.insert(record);
    }

    @Override
    public CatalogProperty selectByPrimaryKey(Long id) {
        return catalogPropertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CatalogProperty> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(CatalogProperty record) {
        return catalogPropertyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CatalogProperty> getCatalogProperty(Long catalogId) {
        return catalogPropertyMapper.getCatalogProperty(catalogId);
    }

    @Override
    public List<CatalogPropertyValue> getCatalogPropertyValue(Long catalogPropertyId) {
        List<CatalogPropertyValue> getCatalogPropertyValue = catalogPropertyValueMapper.getCatalogPropertyValue(catalogPropertyId);
        return getCatalogPropertyValue;
    }
}
