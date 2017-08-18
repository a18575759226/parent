package com.xmg.shop.exception;

/**
 * 登录异常
 * @author
 * @date 2017/8/12
 */
public class LoginException extends RuntimeException{

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
