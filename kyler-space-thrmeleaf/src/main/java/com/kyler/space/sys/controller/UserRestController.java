package com.kyler.space.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyler.space.common.Criteria;
import com.kyler.space.common.pojo.RestResult;
import com.kyler.space.sys.pojo.User;
import com.kyler.space.sys.service.UserService;

/**
 * 用户
 */
@RestController
public class UserRestController {

   @Autowired
	public UserService userService;
   
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userSid}")
	@ResponseBody
    private RestResult findUserById(@PathVariable Long userSid){
		User user = this.userService.selectByPrimaryKey(userSid);
		return new RestResult(RestResult.SUCCESS, "",user);
	}
	
	@GetMapping("/users")
	public List<User> selectUsers(){
		Criteria example = new Criteria();
		List<User> user = this.userService.selectByParams(example);
		if(null != user){
			System.out.println(user.size());
		}
		return user;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
    @ResponseBody
    private RestResult insertUser(User user, HttpServletRequest request){
		int result = 0;
		if(null != user){
			result = this.userService.insertSelective(user);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"用户添加成功");
		}else{
			return new RestResult(RestResult.FAILURE,"用户添加失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userSid}")
    @ResponseBody
    private RestResult updateUser(@PathParam("userSid")int userSid,User user, HttpServletRequest request){
		int result = 0;
		if(null != user){
			result = this.userService.updateByPrimaryKey(user);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"用户更新成功");
		}else{
			return new RestResult(RestResult.FAILURE,"用户更新失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/users/{userSid}")
    @ResponseBody
    private RestResult deleteUser(@PathVariable Long userSid){
		int result = this.userService.deleteByPrimaryKey(userSid);
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"用户删除成功");
		}else{
			return new RestResult(RestResult.FAILURE,"用户删除失败");
		}
	}
}
