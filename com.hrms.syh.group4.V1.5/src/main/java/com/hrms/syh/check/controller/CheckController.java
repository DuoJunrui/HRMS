package com.hrms.syh.check.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.along.entity.DbCheck;
import com.along.entity.DbUser;
import com.hrms.syh.check.service.CheckService;

@Controller
@RequestMapping(value="check")
public class CheckController {
	
	@Autowired
	CheckService checkService;
	
	/**
	 * 查询考勤表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="listCheck",method=RequestMethod.GET)
	public String listCheck() {
		
		List<DbCheck> listCheck = this.checkService.listCheck();
		return JSON.toJSONString(listCheck);
		
	}
	
	/**
	 * 增加考勤表记录
	 */
	@ResponseBody
	@RequestMapping(value="addCheck",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public boolean addCheck(@RequestBody DbCheck dbCheck,HttpServletRequest request, HttpServletResponse response) {
		//员工id
		DbUser getUser = (DbUser) request.getSession().getAttribute("user");
		//String userAccount = getUser.getUser_account();
		//String userPassword = getUser.getUser_password();
		DbUser id = this.checkService.getIdByAccountAndPassword(getUser);
		dbCheck.setStaff_name(id.getId());
		return this.checkService.addCheck(dbCheck);
	}
	
	/**
	 * 修改考勤表记录
	 */
	@ResponseBody
	@RequestMapping(value="updateCheck",method=RequestMethod.POST)
	public boolean updateCheck(@RequestBody DbCheck dbCheck,HttpServletRequest request,HttpServletResponse response) {
		return this.checkService.updateCheck(dbCheck);
	}
	
	/**
	 * 删除考勤表记录
	 */
	@ResponseBody
	@RequestMapping(value="deleteCheck",method=RequestMethod.POST)
	public boolean deleteCheck(@RequestBody DbCheck dbCheck,HttpServletRequest request,HttpServletResponse response) {
		return this.checkService.deleteCheck(dbCheck);
	}
	
}
