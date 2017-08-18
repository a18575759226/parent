package com.xmg.shop.web.util;

import com.xmg.shop.domain.LoginInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * 当前登录用户常用方法工具类
 *
 * @author dongc
 * @date 2017/8/12
 */
public class UserContext {

    private UserContext() {}

    public static final String USER_IN_SESSION = "currentUser";
    public static final String VERIFY_CODE_IN_SESSION = "verifyCode";

    /**
     * 将loginInfo信息添加到session中
     *
     * @param info 需要添加的loginInfo信息
     */
    public static void setCurrentUser(LoginInfo info) {
        getSession().setAttribute(USER_IN_SESSION, info);
    }

    public static LoginInfo getCurrentUser() {
        return (LoginInfo) getSession().getAttribute(USER_IN_SESSION);
    }

    private static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    /**
     * 将验证码信息设置到session中
     */
    public static void setVerifyCode(String verifyCode) {
        getSession().setAttribute(VERIFY_CODE_IN_SESSION, verifyCode);
    }

    public static String getVerifyCode() {
        return (String) getSession().getAttribute(VERIFY_CODE_IN_SESSION);
    }
}
