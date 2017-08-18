package com.xmg.shop.mapper;

import com.xmg.shop.domain.Trademark;

import java.util.List;

public interface TrademarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trademark record);

    Trademark selectByPrimaryKey(Integer id);

    List<Trademark> selectAll();

    int updateByPrimaryKey(Trademark record);
}