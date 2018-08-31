package com.hrms.syh.department.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.along.entity.DbDepartment;
import com.hrms.syh.department.service.DepartmentService;

@Controller
@RequestMapping(value="dept")
public class DepartmentController {
	@Autowired
	DepartmentService deptservice;
	
	/**
	 * 部门列表
	 */
	@ResponseBody
	@RequestMapping(value = "listDepartment", method = RequestMethod.GET)
	public String listDepartment(HttpServletRequest request, HttpServletResponse response) {
		List<DbDepartment> list = this.deptservice.listDepartment();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 添加部门
	 */
	@ResponseBody
	@RequestMapping(value = "addDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String addDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response){
		int count = this.deptservice.addDepartment(dept);
		Map<String ,String> reslut = new HashMap<>();
		reslut.put("msg", "添加成功");
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 修改部门
	 */
	@ResponseBody
	@RequestMapping(value = "updateDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response) {
		boolean succeed = this.deptservice.updateDepartment(dept);
		Map<String ,String> reslut = new HashMap<>();
		//int i=0;
		if(succeed) {
			reslut.put("msg", "部门修改成功");
			
		}else{
			reslut.put("msg", "部门修改失败");
			//i=1;
		}
		return JSON.toJSONString(reslut);
	}
	
	/**
	 * 删除部门
	 */
	@ResponseBody
	@RequestMapping(value = "deleteDepartment", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String deleteDepartment(@RequestBody DbDepartment dept,HttpServletRequest request, HttpServletResponse response) {
		int count = this.deptservice.deleteDepartment(dept);
		Map<String ,String> reslut = new HashMap<>();
		if(count>0)
		{
			reslut.put("msg", "删除成功");
		}else {
			reslut.put("msg", "删除失败");
		}
		return JSON.toJSONString(reslut);
	}
}
