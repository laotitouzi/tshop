package com.tshop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.tshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tshop.entity.User;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping("/save")
	public String save(HttpSession session,String name, String password, Map<String, Object> map) {
		map.put("name", name);
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		userService.insertUser(user);

		session.setAttribute("hello", "woshinidie");
		return "/user/success";
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map) {

		return "/user/success";
	}
}
