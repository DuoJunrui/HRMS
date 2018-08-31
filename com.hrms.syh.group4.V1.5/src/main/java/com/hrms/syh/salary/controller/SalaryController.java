package com.hrms.syh.salary.controller;

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
import com.along.entity.DbSalary;
import com.hrms.syh.salary.service.SalaryService;

/**
 * 
 * @author 多俊睿
 * @date 2018年8月28日 上午1:47:20 
 *
 */

@Controller
@RequestMapping(value = "salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;

	//添加工资记录
	@ResponseBody
	@RequestMapping(value = "insertSalary", method = RequestMethod.POST)
	public String insterSalary(@RequestBody DbSalary salary) {
		if (this.salaryService.insertSalary(salary) > 0) {
			return "succeed";
		}
		return "failure";
	}
	
	//根据ID删除工资单
	@ResponseBody
	@RequestMapping(value = "deleteSalary", method = RequestMethod.DELETE)
	public String deleteSalary(@RequestBody DbSalary salary) {
		if (this.salaryService.deleteSalary(salary) > 0) {
			return "succeed";
		}
		return "failure";
	}
	
	//查询工资列表
	@ResponseBody
	@RequestMapping(value = "selectSalary", method = RequestMethod.GET)
	public String selectSalary(HttpServletRequest request, HttpServletResponse response) {
		List<DbSalary> list = this.salaryService.selectSalary();
		return JSON.toJSONString(list);
	}

	//根据ID修改工资单
	@ResponseBody
	@RequestMapping(value = "updateSalary", method = RequestMethod.POST)
	public String updateSalary(@RequestBody DbSalary salary) {
		if (this.salaryService.updateSalary(salary)  > 0) {
			return "succeed";
		}
		return "failure";
	}


}
