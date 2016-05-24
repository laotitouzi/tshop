package com.tshop.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tshop.service.UserService;
import com.tshop.token.Token;
import com.tshop.utils.Config;
import com.tshop.utils.CookieUtils;
import com.tshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tshop.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @Token(save=true)
    @RequestMapping("/register")
    public String register() {
        return "/user/register";
    }

    @Token(save=true)
    @RequestMapping("/login")
    public String login() {
        return "/user/login";
    }


    @RequestMapping("/dologin")
    public String doLogin(HttpServletRequest request, HttpServletResponse response, User user, boolean rememberMe) {
        if (user == null) {
            return "redirect:/user/login";
        }

        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return "redirect:/user/login";
        }
        User realUser = userService.getUser(user.getUsername(), user.getPassword());
        int age = -1;
        if (rememberMe) {
            age = 60 * 60 * 24 * 7;
        }
        saveSessionAndCookie(request, response, realUser, age);
        return "redirect:/";
    }

    @RequestMapping("/dologout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(Config.SESSION_NAME_LOGIN_USER);
        CookieUtils.deleteCookie(request, response, Config.TSHOP_COOKIE_NAME, "/");
        return "redirect:/";
    }

    private void saveSessionAndCookie(HttpServletRequest request, HttpServletResponse response, Object obj, int age) {
        String content = "";
        if (obj != null) {
            try {
                byte[] bytes = JsonUtils.toJSONString(obj).getBytes("UTF-8");
                content = new String(Base64Utils.encode(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //TODO 加密
            request.getSession().setAttribute(Config.SESSION_NAME_LOGIN_USER, obj);
            CookieUtils.addCookie(response, Config.TSHOP_COOKIE_NAME, content, "/", age);
        }
    }

    @RequestMapping("/info")
    public String info(HttpServletRequest request, Model model) {
        return "/user/info";
    }

    public String save(@RequestParam("id") int inputId) {
        return null;
    }

    @RequestMapping("/doregister")
    public String doRegister(HttpServletRequest request, HttpServletResponse response, User user) {
        userService.insertUser(user);
        this.saveSessionAndCookie(request, response, user, 60 * 60 * 24 * 7);
        return "redirect:/";

    }

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        return "/user/success";
    }

    @Token(save=true)
    @RequestMapping("/forgetpasswd")
    public String forgetPasswd(){
        return "/user/forgetpasswd";
    }

    @RequestMapping("/dogetpasswd")
    public String doGetasswd(){
        return "/user/forgetpasswd";
    }
}
