package com.tshop.utils;

import com.tshop.entity.User;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.server.Authentication;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Han, Tixiang
 * @Create 2016/5/17
 */
public class CookieUtils {

    public static Cookie addCookie(HttpServletResponse response, String cookieName, String cookieValue, String path, int age) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath(path == null ? "/" : path);
        cookie.setMaxAge(age);
        response.addCookie(cookie);
        return cookie;
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,String path) {
        if (StringUtils.isBlank(cookieName))
            return;
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setPath(path == null ? "/" : path);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        if (StringUtils.isBlank(cookieName))
            return null;
        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length < 1)
            return null;

        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HttpServletResponse response = new MockHttpServletResponse();
        HttpServletRequest request = new MockHttpServletRequest();
        User user = new User();
        user.setUsername("zhangsan");
        String content = JsonUtils.toJSONString(user);
        addCookie(response, "cookie1", content, "/", 60 * 60 * 24 * 7);


     /*   Cookie co = getCookieByName(request,"cookie1");

        String content2 = co.getValue();
        //TODO 解密
        User  u  = JsonUtils.parse(content2,User.class);

        System.out.print(u.getUsername());*/
        //TODO 加密
    }
}
