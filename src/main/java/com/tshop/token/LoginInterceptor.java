package com.tshop.token;

import com.tshop.entity.User;
import com.tshop.utils.Constant;
import com.tshop.utils.CookieUtils;
import com.tshop.utils.JsonUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {


	private String login_url = "/user/login";
    private String[] filterURIs= new String[]{"/"};

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User  user  = null;
        user = (User) request.getSession().getAttribute(Constant.SESSION_NAME_LOGIN_USER);

		if(user!=null){
			return true;
		}
        Cookie cookie = CookieUtils.getCookieByName(request, Constant.TSHOP_COOKIE_NAME);
        if(cookie!=null){
            String content = new String(Base64Utils.decode(cookie.getValue().getBytes("UTF-8")));
             user  = JsonUtils.parse(content,User.class);
            if(user!=null){
                request.getSession().setAttribute(Constant.SESSION_NAME_LOGIN_USER,user);
                return  true;
            }
        }

        if(!isFilter(request.getRequestURI())){
            response.sendRedirect(login_url);
        }
        return  true;
    }

    private boolean isFilter(String requestURI) {
        for(String url :filterURIs){
            if(url.equals(requestURI)){
                return true;
            }
        }
        return false;
    }
}