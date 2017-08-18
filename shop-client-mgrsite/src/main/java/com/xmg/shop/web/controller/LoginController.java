package com.xmg.shop.web.controller;

import com.xmg.shop.domain.LoginInfo;
import com.xmg.shop.service.ILoginInfoService;
import com.xmg.shop.util.AjaxResult;
import com.xmg.shop.web.util.UserContext;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author
 * @date 2017/8/12
 */
@Controller
public class LoginController {
    @Autowired
    private ILoginInfoService loginInfoService;

    /**
     * 登录校验
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public AjaxResult login(String username, String password, String verifyCode, HttpSession session) {
        AjaxResult result = null;
        try {
            if (StringUtils.isBlank(verifyCode)){
                result = new AjaxResult("验证码不能为空");
                return result;
            }
            String verifyCode_in_session = (String) session.getAttribute("verifyCode");
            if (!verifyCode_in_session.equals(verifyCode)){
                result = new AjaxResult("验证码错误");
                return result;
            }
            LoginInfo loginInfo = loginInfoService.checkLogin(username, password);
            if (loginInfo!= null){
                //session.setAttribute("currentUser",loginInfo);
                UserContext.setCurrentUser(loginInfo);
            }
            result = new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("---------------"+e.getMessage());
            result = new AjaxResult("用户名或者密码错误");
        }
        return result;
    }

    /**
     * 登录校验
     */
    @RequestMapping("/main.do")
    public String main(Model model) {
        LoginInfo loginInfo = UserContext.getCurrentUser();
        model.addAttribute("loginInfo", loginInfo);
        return "main";
    }

    /**
     * 页面安全退出功能
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
