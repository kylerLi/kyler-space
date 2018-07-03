package com.kyler.space.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	 @RequestMapping(method = RequestMethod.GET, value = "/")
	    public String index(HttpServletRequest request) {
	        return "index";
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/markdown_edit")
	    public String markdown(HttpServletRequest request) {
			System.out.println("markdown edit :" + request.getRequestURI());
			request.setAttribute("ctx", 123);
	        return "iframe/markdown/markdown_edit";
	 }
}
