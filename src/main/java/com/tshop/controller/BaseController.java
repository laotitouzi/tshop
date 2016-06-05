package com.tshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.tshop.utils.Constant;
import com.tshop.utils.CookieUtils;
import com.tshop.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
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
    protected static String CODE_IS_BLANK = "请输入验证码";
    protected static String CODE_IS_WRONG = "验证码输入错误";
    protected static String BASIC_MESSAGE_MUST_INPUT = "请输入基本信息";
    protected static String BASIC_MUST_INPUT_DELETE_ID_OR_IDS = "请选择你要删除的内容";
    protected static String ADD = "新增";
    protected static String UPDATE = "修改";
    protected static String DELETE = "删除";
    protected static String QUERY = "查询";
    protected static String OK = "成功";
    protected static String ERROR = "失败";

    protected void putErrorsInSession(HttpServletRequest request, List<ObjectError> allErrors) {
        request.getSession().setAttribute(Constant.ERRORS, allErrors);
    }

    protected JSONObject checkCode(HttpServletRequest request, String code) {
        if (StringUtils.isEmpty(code)) {
            return this.resonseError(CODE_IS_BLANK);
        } else if (!request.getSession().getAttribute(Constant.CHECKCODE).equals(code.toUpperCase())) {
            return resonseError("CODE_IS_WRONG");
        }
        request.getSession().removeAttribute(Constant.CHECKCODE);
        return null;
    }

    protected void putObjectInSession(HttpServletRequest request, String key, Object obj) {
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
        request.getSession().setAttribute(key, obj);
    }

    protected void putObjectInCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, Object obj) {
        putObjectInCookie(request, response, cookieName, obj, "/", 7 * 24 * 24);
    }

    protected void putObjectInCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, Object obj, String path, int age) {
        if (obj == null) {
            return;
        }
        try {
            byte[] bytes = JsonUtils.toJSONString(obj).getBytes("UTF-8");
            String content = new String(Base64Utils.encode(bytes));
            CookieUtils.addCookie(response, cookieName, content, path, age);
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

    protected JSONObject resonseOk() {
        return this.response(true, "");
    }

    protected JSONObject resonseOk(String message) {
        return this.response(true, message);
    }

    protected JSONObject responseError(){
        return this.resonseError("");
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
