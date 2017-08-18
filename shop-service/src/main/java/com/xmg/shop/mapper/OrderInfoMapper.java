package com.xmg.shop.mapper;

import com.xmg.shop.domain.OrderInfo;
import com.xmg.shop.query.OrderQueryObject;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    List<OrderInfo> selectAll();

    int updateByPrimaryKey(OrderInfo record);

    Long  count (OrderQueryObject qo );

    List<OrderInfo> queryPage (OrderQueryObject qo) ;
}