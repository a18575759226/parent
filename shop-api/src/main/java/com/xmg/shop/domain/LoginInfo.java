package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 登录信息实体类
 */
@Getter
@Setter
@ToString
public class LoginInfo implements Serializable{

    private Long id;//主键id,自增长

    private String userName;//用户名

    private String password;//密码

    private Byte state = 0;//账户状态,0为正常,1为冻结,默认为0

    private Byte userType;//用户类型,0为管理员,1为普通用户

}