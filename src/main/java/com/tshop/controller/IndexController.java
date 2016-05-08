package com.tshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tshop.token.Token;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	@Token(save = true)
	public String index(HttpSession session) {
		double d = Math.random();

		return "index";
	}

	@RequestMapping("/repet_submit")
	public String repetSubmit() {
		return "error/repet_submit";
	}
}
