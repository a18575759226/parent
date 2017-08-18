package com.xmg.shop.service.impl;

import com.xmg.shop.domain.CatalogPropertyValue;
import com.xmg.shop.mapper.CatalogPropertyValueMapper;
import com.xmg.shop.service.ICatalogPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/08/14.
 */
@Service
public class CatalogPropertyValueServiceImpl implements ICatalogPropertyValueService {

    @Autowired
    private CatalogPropertyValueMapper catalogPropertyValueMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return catalogPropertyValueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CatalogPropertyValue record) {
        return catalogPropertyValueMapper.insert(record);
    }

    @Override
    public CatalogPropertyValue selectByPrimaryKey(Long id) {
        return catalogPropertyValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CatalogPropertyValue> selectAll() {
        return catalogPropertyValueMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CatalogPropertyValue record) {
        return catalogPropertyValueMapper.updateByPrimaryKey(record);
    }
}
