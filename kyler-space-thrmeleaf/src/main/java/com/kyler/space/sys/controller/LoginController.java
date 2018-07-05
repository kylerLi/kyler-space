package com.kyler.space.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	 @RequestMapping(method = RequestMethod.GET, value = "/")
	    public String index(HttpServletRequest request) {
		    List<Map<String,Object>> lists = new ArrayList<>();
		    Map<String,Object> maps = new HashMap<>();
		    maps.put("blog", "markdown");
		    lists.add(maps);
		    request.setAttribute("lists", lists);
	        return "index";
	 }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/markdown_edit")
	    public String markdown(HttpServletRequest request) {
	        return "markdown/markdown_edit";
	 }
	 
	    @RequestMapping("edit")
	    public String   editor(){
	        return "markdown/edit";
	    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/markdown_demo")
	    public String demo(HttpServletRequest request) {
	        return "markdown/demo";
	 }
}
