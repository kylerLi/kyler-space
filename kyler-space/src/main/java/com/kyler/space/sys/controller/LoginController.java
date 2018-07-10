package com.kyler.space.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(HttpServletRequest request) {
	    
	    request.setAttribute("template_path", "ablout-me");
	    request.setAttribute("template_fragment", "me");
	    request.setAttribute("level", 0);
        return "index";
	}
	 
	@RequestMapping(method = RequestMethod.GET, value = "/system")
    public String system(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "markdown/article_edit");
		request.setAttribute("fragment", "edit");
		request.setAttribute("level", 1);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/system/article_list")
    public String article_list(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "markdown/article_list");
		request.setAttribute("fragment", "list");
		request.setAttribute("level", 1);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/havefun")
    public String edit(HttpServletRequest request) {
		request.setAttribute("template_folder", "relax/havefun");
		request.setAttribute("template_path", "fun");
		request.setAttribute("level", 0);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/blog")
    public String template(HttpServletRequest request) {
		request.setAttribute("template_folder", "blog/blog_list");
		request.setAttribute("template_path", "list");
        return "index";
	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/datatables")
    public String datatables(HttpServletRequest request) {
        return "datatables";
	}
}
