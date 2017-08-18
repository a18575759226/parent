package com.xmg.shop.service.impl;

import com.xmg.shop.domain.LoginInfo;
import com.xmg.shop.exception.LoginException;
import com.xmg.shop.mapper.LoginInfoMapper;
import com.xmg.shop.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录信息具体业务实现类
 *
 * @author dongc
 * @date 2017/8/12
 */
@Service
public class LoginInfoServiceImpl implements ILoginInfoService {
    @Autowired
    private LoginInfoMapper loginInfoMapper;

    /**
     * 登录校验
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录对象
     */
    @Override
    public LoginInfo checkLogin(String username, String password) {

        LoginInfo loginInfo = loginInfoMapper.checkLogin(username, password);
        if (loginInfo == null) {
            throw new LoginException("用户名或密码错误,请重新输入");
        }
        ////就用户信息添加到session中
        //UserContext.setCurrentUser(loginInfo);
        return loginInfo;
    }

    /**
     * 校验验证码信息
     *
     * @param verifyCode 验证码
     * @return 验证码
     */
    @Override
    public String checkVerifyCode(String verifyCode) {
        if (verifyCode == null) {
            throw new LoginException("验证码为空");
        }
        ////将验证码信息储存在session中
        //String verifyCode_in_session = UserContext.getVerifyCode();
        //if (verifyCode_in_session != null && !verifyCode_in_session.equals(verifyCode)) {
        //    throw new LoginException("验证码错误,请重新输入!");
        //}
        return verifyCode;
    }
}
