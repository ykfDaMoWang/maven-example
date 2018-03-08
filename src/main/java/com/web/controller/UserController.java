package com.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.web.entity.User;
import com.web.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api(value="/user",tags="用户接口")
public class UserController extends BaseController{
	
	@Resource
	private IUserService userService;
	
	@ApiOperation(value = "根据id查找用户", httpMethod = "GET")
	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="int",paramType = "query",defaultValue="1")
	@RequestMapping(value="/findUserById")
	public ModelAndView findUserById(int id){
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",userService.getUserById(id));
		mv.setViewName("user");
		return mv;
	}
	
	@ApiOperation(value = "更新用户信息", httpMethod = "PUT")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="编号",required=true,dataType="int", paramType = "query",defaultValue="1"),
		@ApiImplicitParam(name="name",value="昵称",required=true,dataType="String", paramType = "query",defaultValue="ceshi"),
		@ApiImplicitParam(name="age",value="年龄",required=true,dataType="int", paramType = "query",defaultValue="12")
	})
	@RequestMapping(value="/updateUser")
	public ModelAndView updateUser(User user){
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","更新成功");
		userService.updateUserById(user);
		mv.setViewName("user");
		return mv;
	}
	
	@ApiOperation(value = "新增用户", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="编号，数据库主键自增不需要填入",dataType="int", paramType = "query"),
		@ApiImplicitParam(name="name",value="昵称",required=true,dataType="String", paramType = "query",defaultValue="ceshi"),
		@ApiImplicitParam(name="age",value="年龄",required=true,dataType="int", paramType = "query",defaultValue="12")
	})
	@RequestMapping(value="/addUser")
	public void addUser(HttpServletResponse response,User user){
		userService.addUser(user);
		this.flushResponse(response, JSON.toJSONString(user));
	}
	
	@ApiOperation(value = "查找所有用户", httpMethod = "GET")
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response){
		List<User> ulist=userService.getAllUser();
		this.flushResponse(response, JSON.toJSONString(ulist));
	}
	
	@ApiOperation(value = "根据id删除用户", httpMethod = "DELETE")
	@ApiImplicitParam(name="id",value="编号",required=true,dataType="int", paramType = "query")
	@RequestMapping("/deleteUserById")
	public void deleteUserById(HttpServletResponse response,int id){
		userService.deleteUserById(id);
		this.flushResponse(response, "注销用户成功");
	}
	
	
}
