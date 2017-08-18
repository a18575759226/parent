package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户
 */
@Getter@Setter
public class Users {

    public static final int BOY = 1 ;//男
    public static final int GIRL = 0 ;//男

    private Long id;

    private String nickName;//用户昵称

    private String account;//用户账号

    private String password;//用户密码

    private String phone;//电话号码

    private String email;//邮箱地址

    private int  sex;//性别

    private Date birthday;//生日

    private BigDecimal userMoney;//用户余额

    private Date registertime;//注册时间

    private Date endtime;//结束时间

    /**
     * 对性别的处理
     * @return
     */
    public String getSex(){
        return sex==1?"男":"女";
    }

}