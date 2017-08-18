package com.xmg.shop.service;

import com.xmg.shop.domain.LoginInfo;

/**
 * 登录用户业务接口
 * @author dongc
 * @date 2017/8/12
 */
public interface ILoginInfoService {
    /**
     * 登录校验
     * @param username 用户名
     * @param password 密码
     * @return 登录对象
     */
    LoginInfo checkLogin(String username, String password);

    /**
     * 校验验证码信息
     * @param verifyCode 验证码
     * @return
     */
    String checkVerifyCode(String verifyCode);
}
