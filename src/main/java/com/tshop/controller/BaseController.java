package com.tshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.tshop.utils.Constant;
import com.tshop.utils.CookieUtils;
import com.tshop.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * @Author Han, Tixiang
 * @Create 2016/5/28
 */
public class BaseController {
    protected static String REDIRECT_TO_LOGIN_PAGE = "redirect:/user/login";
    protected static String REDIRECT_TO_REGISTER_PAGE = "redirect:/user/register";
    protected static String REDIRECT_TO_INDEX_PAGE = "redirect:/";

    protected void putErrorsInSession(HttpServletRequest request, List<ObjectError> allErrors) {
        request.getSession().setAttribute(Constant.ERRORS, allErrors);
    }

    protected void putObjectInSession(HttpServletRequest request, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            byte[] bytes = JsonUtils.toJSONString(obj).getBytes("UTF-8");
            String content = new String(Base64Utils.encode(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO 加密
        request.getSession().setAttribute(Constant.SESSION_NAME_LOGIN_USER, obj);
    }

    protected void putObjectInCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, Object obj, int age) {
        if (obj == null) {
            return;
        }
        try {
            byte[] bytes = JsonUtils.toJSONString(obj).getBytes("UTF-8");
            String content = new String(Base64Utils.encode(bytes));
            CookieUtils.addCookie(response, cookieName, content, "/", age);
        } catch (Exception e) {
            return;
        }
    }

    protected void saveSessionAndCookie(HttpServletRequest request, HttpServletResponse response, Object obj, int age) {
        String content = "";
        if (obj != null) {
            try {
                byte[] bytes = JsonUtils.toJSONString(obj).getBytes("UTF-8");
                content = new String(Base64Utils.encode(bytes));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //TODO 加密
            request.getSession().setAttribute(Constant.SESSION_NAME_LOGIN_USER, obj);
            CookieUtils.addCookie(response, Constant.TSHOP_COOKIE_NAME, content, "/", age);
        }
    }

    protected JSONObject resonseError(List<ObjectError> allErrors) {
        String message = "";
        for (ObjectError error : allErrors) {
            message += error.getDefaultMessage() + "\n";
        }
        return response(false, message);
    }

    protected JSONObject resonseSuccess() {
        return this.response(true, "");
    }
    protected JSONObject resonseSuccess(String message) {
        return this.response(true, message);
    }

    protected JSONObject resonseError(String message) {
        return this.response(false, message);
    }

    private JSONObject response(boolean flag, String... res) {
        JSONObject obj = new JSONObject();
        obj.put("status", flag ? 1 : 0);
        obj.put("message", res);
        return obj;
    }
}
