package com.xmg.shop.mapper;

import com.xmg.shop.domain.Users;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
}