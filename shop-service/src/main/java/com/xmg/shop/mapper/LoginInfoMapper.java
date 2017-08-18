package com.xmg.shop.mapper;

import com.xmg.shop.domain.LoginInfo;
import org.apache.ibatis.annotations.Param;

public interface LoginInfoMapper {

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LoginInfo record);

    LoginInfo checkLogin(@Param("username") String username, @Param("password")String password);
}