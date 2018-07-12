package com.kyler.space.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(HttpServletRequest request) {
	    
	    request.setAttribute("template_path", "ablout");
	    request.setAttribute("template_fragment", "me");
	    request.setAttribute("active_head", "about");
	    request.setAttribute("level", 0);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/system")
    public String system(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "markdown/article_edit");
		request.setAttribute("fragment", "edit");
		request.setAttribute("active_left_menu", "article_edit");
		request.setAttribute("active_head", "system");
		request.setAttribute("level", 1);
        return "index";
	}
	
	 
	@RequestMapping(method = RequestMethod.GET, value = "/markdown/article_edit")
    public String article_edit(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "markdown/article_edit");
		request.setAttribute("fragment", "edit");
		request.setAttribute("active_left_menu", "article_edit");
		request.setAttribute("active_head", "system");
        
		request.setAttribute("level", 1);
		
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/markdown/article_list")
    public String article_list(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "markdown/article_list");
		request.setAttribute("fragment", "list");
		request.setAttribute("active_left_menu", "article_list");
		request.setAttribute("active_head", "system");

		request.setAttribute("level", 1);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/system/config_list")
    public String config_list(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "system/config_list");
		request.setAttribute("fragment", "list");
		request.setAttribute("active_left_menu", "config_list");
		request.setAttribute("level", 1);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/system/user_list")
    public String user_list(HttpServletRequest request) {
		request.setAttribute("template_path", "system/sys-m-mgt");
		request.setAttribute("path", "system/user_list");
		request.setAttribute("fragment", "list");
		request.setAttribute("active_left_menu", "user_list");
		request.setAttribute("active_head", "system");

		request.setAttribute("level", 1);
        return "index";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/relax")
    public String edit(HttpServletRequest request) {
		request.setAttribute("template_path", "relax/havefun");
		request.setAttribute("template_fragment", "havefun");
		request.setAttribute("active_head", "havefun");
		request.setAttribute("level", 0);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/blogs")
    public String template(HttpServletRequest request) {
		request.setAttribute("template_path", "blog/blog_list");
		request.setAttribute("template_fragment", "blogs");
		request.setAttribute("active_head", "blogs");
		request.setAttribute("level", 0);
        return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/about")
    public String about(HttpServletRequest request) {
		request.setAttribute("template_path", "ablout");
	    request.setAttribute("template_fragment", "me");
	    request.setAttribute("active_head", "about");
	    request.setAttribute("level", 0);
        return "index";
	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/datatables")
    public String datatables(HttpServletRequest request) {
        return "datatables";
	}
}
