package com.xmg.shop.service.impl;

import com.xmg.shop.domain.OrderInfo;
import com.xmg.shop.mapper.OrderInfoMapper;
import com.xmg.shop.page.PageResult;
import com.xmg.shop.query.OrderQueryObject;
import com.xmg.shop.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JINZHAOYU on 2017/8/15.
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper ;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(OrderInfo record) {
        return 0;
    }

    @Override
    public OrderInfo selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<OrderInfo> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return 0;
    }

    @Override
    public PageResult query(OrderQueryObject qo) {

        Long count  =  orderInfoMapper.count(qo);
        if (count == 0){

            return  new PageResult().empty(qo.getPageSize());
        }
        List<OrderInfo> dataList =  orderInfoMapper.queryPage(qo);
        return new PageResult(dataList,count.intValue(),qo.getCurrentPage(),qo.getPageSize() );
    }
}
