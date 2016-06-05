package com.tshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.tshop.entity.User;
import com.tshop.exception.BusinessException;
import com.tshop.service.UserService;
import com.tshop.token.Token;
import com.tshop.utils.Constant;
import com.tshop.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @RequestMapping(value = "/dologin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest request, HttpServletResponse response, String code, boolean rememberMe, @Valid User user, BindingResult result) {
        if (user == null) {
            return resonseError("请输入用户信息");
        }

        if (result.hasErrors()) {
            return resonseError(result.getAllErrors());
        }

        JSONObject checkCodeResult = this.checkCode(request, code);

        if (checkCodeResult != null) {
            return checkCodeResult;
        }

        User realUser = userService.getUser(user.getUsername(), user.getPassword());

        if (realUser == null) {
            return resonseError("用户名或者密码错误");
        }

        int age = -1;
        if (rememberMe) {
            age = 60 * 60 * 24 * 7;
        }
        this.putObjectInSession(request,Constant.SESSION_NAME_LOGIN_USER,realUser);
        this.putObjectInCookie(request,response,Constant.TSHOP_COOKIE_NAME,realUser);
        return resonseOk();
    }


    @RequestMapping("/dologout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(Constant.SESSION_NAME_LOGIN_USER);
        CookieUtils.deleteCookie(request, response, Constant.TSHOP_COOKIE_NAME, "/");
        return REDIRECT_TO_INDEX_PAGE;
    }


    @RequestMapping("/info")
    public String info(HttpServletRequest request, Model model) throws Exception {

        throw new BusinessException("adfds");
        //return "/user/info";

    }

    public String save(@RequestParam("id") int inputId) {


        return null;
    }

    @RequestMapping("/doregister")
    @ResponseBody
    public JSONObject doRegister(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return resonseError("请输入用户信息");
        }
        userService.addUser(user);
        this.putObjectInSession(request, Constant.SESSION_NAME_LOGIN_USER, user);
        this.putObjectInCookie(request, response, Constant.TSHOP_COOKIE_NAME, user);
        return resonseOk();

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
