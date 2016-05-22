package com.tshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bbtForum.do")
class MethodController {

        @RequestMapping(params = "method=createTopic",method = RequestMethod.POST)
        public String createTopic(){
            System.out.println("call createTopic method.");
            return "createTopic";
        }
}

