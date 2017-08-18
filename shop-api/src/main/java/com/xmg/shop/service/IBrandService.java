package com.xmg.shop.service;

import com.xmg.shop.domain.Brand;

import java.util.List;

/**
 * 品牌的业务接口
 * @author dongc
 * @date 2017/8/11
 */
public interface IBrandService {
    /**
     * 通过id获取产品信息
     * @param id 产品id
     * @return
     */
    Brand get(Long id);

    /**
     *
     * @return
     */
    List<Brand> selectAll();
}
