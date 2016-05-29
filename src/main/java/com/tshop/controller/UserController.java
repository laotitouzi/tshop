package com.tshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.tshop.entity.User;
import com.tshop.service.UserService;
import com.tshop.token.Token;
import com.tshop.utils.Constant;
import com.tshop.utils.CookieUtils;
import com.tshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    public UserService userService;

    @Token(save = true)
    @RequestMapping("/register")
    public String register() {
        return "/user/register";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "/user/login";
    }

    @RequestMapping(value="/dologin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, HttpServletResponse response, String code, String pwd,boolean rememberMe, @Valid User user, BindingResult result) {
        if (user == null) {
            return resonseError("请输入用户信息");
        }

        if (StringUtils.isEmpty(code)){
            return resonseError("请输入验证码");
        }

        if (result.hasErrors()) {
            return resonseError(result.getAllErrors());
        }

        if(MD5Utils.md5(user.getPassword()).equals(pwd)){
            user.setPassword(pwd);
        }else{
            return resonseError("密码设置有误");
        }

        if( !request.getSession().getAttribute(Constant.CHECKCODE).equals(code.toUpperCase())) {
            return resonseError("验证码输入错误");
        }

        User realUser = userService.getUser(user.getUsername(), MD5Utils.md5(user.getPassword().trim()));

        if(realUser==null){
            return resonseError("用户名或者密码错误");
        }

        int age = -1;
        if (rememberMe) {
            age = 60 * 60 * 24 * 7;
        }
        saveSessionAndCookie(request, response, realUser, age);
        return resonseSuccess();
    }


    @RequestMapping("/dologout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(Constant.SESSION_NAME_LOGIN_USER);
        CookieUtils.deleteCookie(request, response, Constant.TSHOP_COOKIE_NAME, "/");
        return REDIRECT_TO_INDEX_PAGE;
    }


    @RequestMapping("/info")
    public String info(HttpServletRequest request, Model model) {
        return "/user/info";
    }

    public String save(@RequestParam("id") int inputId) {
        return null;
    }

    @RequestMapping("/doregister")
    @ResponseBody
    public JSONObject doRegister(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            putErrorsInSession(request, result.getAllErrors());
            return resonseError("请输入用户信息");
        }
        userService.insertUser(user);
        saveSessionAndCookie(request, response, user, 60 * 60 * 24 * 7);
        return resonseSuccess();

    }

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        return "/user/success";
    }

    @Token(save = true)
    @RequestMapping("/forgetpasswd")
    public String forgetPasswd() {
        return "/user/forgetpasswd";
    }

    @RequestMapping("/dogetpasswd")
    public String doGetasswd() {
        return "/user/forgetpasswd";
    }
}
