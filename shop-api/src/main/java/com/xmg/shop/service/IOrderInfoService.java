package com.xmg.shop.service;

import com.xmg.shop.domain.OrderInfo;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.OrderQueryObject;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/15.
 */
public interface IOrderInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    List<OrderInfo> selectAll();

    int updateByPrimaryKey(OrderInfo record);

    PageResult query(OrderQueryObject qo );

}
