package com.tshop.controller;

import javax.servlet.http.HttpSession;

import com.tshop.entity.Product;
import com.tshop.page.Criteria;
import com.tshop.service.ProductService;
import com.tshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tshop.token.Token;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	public ProductService productService;


	@RequestMapping(value="/")
	public String index(HttpSession session,Model model) {
		Criteria criteria = new Criteria();
		criteria.put("category","1");
		List<Product> productList = productService.queryProductForList(criteria);
		model.addAttribute("products" ,productList);
		return "index";
	}

	@RequestMapping("/repet_submit")
	public String repetSubmit() {
		return "error/repet_submit";
	}

	@RequestMapping(value="/print")
	@ResponseBody
	public String print(){
		String message = "Hello World, Spring MVC!";
		return message;
	}
}
