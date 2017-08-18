package com.xmg.shop.service.impl;

import com.xmg.shop.domain.Brand;
import com.xmg.shop.mapper.BrandMapper;
import com.xmg.shop.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2017/8/11
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;
    /**
     * 通过id获取产品信息
     *
     * @param id 产品id
     * @return
     */
    public Brand get(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * @return
     */
    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }
}
