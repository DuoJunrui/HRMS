package com.hrms.syh.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.along.entity.DbUser;
import com.hrms.syh.user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	UserService userservice;
	
	/**
	 * 用户列表
	 */
	@ResponseBody
	@RequestMapping(value = "listUser", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request, HttpServletResponse response) {
		List<DbUser> list=this.userservice.listUser();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 添加用户
	 */
	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String addUser(@RequestBody DbUser user,HttpServletRequest request, HttpServletResponse response){
		int count = this.userservice.addUser(user);
		Map<String ,String> reslut = new HashMap<>();
		reslut.put("msg", "添加成功");
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 修改用户
	 */
	@ResponseBody
	@RequestMapping(value = "updateUser", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateUser(@RequestBody DbUser user,HttpServletRequest request, HttpServletResponse response){
		Map<String ,String> reslut = new HashMap<>();
		if(this.userservice.updateUser(user)) {
			reslut.put("msg", "用户修改成功");
		}else {
			reslut.put("msg", "用户修改失败");
		}
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "deleteUser", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String deleteUser(@RequestBody DbUser user,HttpServletRequest request, HttpServletResponse response) {
		int count = this.userservice.deleteUser(user);
		Map<String ,String> reslut = new HashMap<>();
		if(count>0)
		{
			reslut.put("msg", "删除成功");
		}else {
			reslut.put("msg", "删除失败");
		}
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 用户登陆
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String loginByUserNameAndPassword(@RequestBody DbUser user,HttpServletRequest request, HttpServletResponse response) {
		boolean succeed = this.userservice.loginByUserNameAndPassword(user);
		System.out.println("login..."+JSON.toJSONString(user));
		Map<String ,String> reslut = new HashMap<>();
		
		if(succeed) {
			reslut.put("msg", "登陆成功");
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			//从数据库获取用户信息放到session
			//TODO
			session.setAttribute("user", user);
		}else {
		reslut.put("msg", "登陆失败");
	}
	return JSON.toJSONString(reslut);
}
	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout")
	   public String logout(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
	       session.removeAttribute("user_account");
	       session.invalidate();
	       return "redirect:http://localhost:8080/hrms/login.html";
	   }
	
}
