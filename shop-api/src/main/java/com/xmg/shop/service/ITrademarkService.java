package com.xmg.shop.service;
import com.xmg.shop.domain.Trademark;

import java.util.List;

public interface ITrademarkService {
	int deleteByPrimaryKey(int id);
    int insert(Trademark record);
    Trademark selectByPrimaryKey(int id);
    List<Trademark> selectAll();
    int updateByPrimaryKey(Trademark record);

    /**
     * 新增或者是修改操作
     * @param trademark
     */
    void saveOrUpdate(Trademark trademark);

    //void productSave(Trademark trademark);
}
