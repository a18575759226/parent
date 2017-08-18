package com.xmg.shop.service.impl;


import com.xmg.shop.domain.Trademark;
import com.xmg.shop.mapper.TrademarkMapper;
import com.xmg.shop.service.ITrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkServiceImpl implements ITrademarkService {
	@Autowired
	private TrademarkMapper trademarkMapper;
	
	public int TrademarkreControllerdeleteByPrimaryKey(int id) {
		return trademarkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		return trademarkMapper.deleteByPrimaryKey(id);
	}

	public int insert(Trademark record) {
		return trademarkMapper.insert(record);
	}

	public Trademark selectByPrimaryKey(int id) {
		return trademarkMapper.selectByPrimaryKey(id);
	}

	public List<Trademark> selectAll() {
		return trademarkMapper.selectAll();
	}

	public int updateByPrimaryKey(Trademark record) {
		return trademarkMapper.updateByPrimaryKey(record);
	}

    @Override
    public void saveOrUpdate(Trademark trademark) {
        if(trademark.getId()==null){
			trademarkMapper.insert(trademark);
        }else{
			trademarkMapper.updateByPrimaryKey(trademark);
		}
    }


}

