package com.hrms.syh.staff.controller;

import java.util.List;
import java.util.Random;

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
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.along.entity.DbStaff;
import com.hrms.syh.staff.service.StaffService;

@Controller
@RequestMapping(value = "staff")
public class StaffController {

	@Autowired
	private StaffService staffService;


	/**
	 * 查询员工列表（有分页）
	 */
	@ResponseBody
	@RequestMapping(value = "listStaff", method = RequestMethod.GET)
	public String listStaff(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		DbStaff staff = (DbStaff) session.getAttribute("staff");
		if (staff == null) {
			System.out.println("没有员工信息");
		} else {
			System.out.println("当前的员工是" + JSON.toJSONString(staff));
		}

		System.out.println("----------------listStaff--begin");
		List<DbStaff> staffList = this.staffService.listStaff();
		System.out.println("----------------Staff");
		System.out.println(JSON.toJSONString(staffList.get(0)));

		session.setAttribute("staff", staffList.get((new Random()).nextInt(staffList.size())));

		System.out.println("----------------staffList");
		System.out.println(JSON.toJSONString(staffList));
		System.out.println("----------------");
		return JSON.toJSONString(staffList);
	}

	/**
	 * 统计员工数量
	 */
	@ResponseBody
	@RequestMapping(value = "getStaffCount", method = RequestMethod.GET)
	public String getStaffCount() {
		System.out.println("----------------getStaffCount--begin");
		int taffCount = this.staffService.getStaffCount();
		System.out.println("----------------getStaffCount--end");
		return "{\"taffCount\":"+taffCount+"}";
	}


	/**
	 * 添加员工
	 * 
	 * @param name
	 * @param sex
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addStaff", method = RequestMethod.POST)
	public String addStaff(@RequestBody DbStaff staff) {
		// TODO
		System.out.println("添加员工。。。123");
		System.out.println(JSON.toJSONString(staff));
		String s="成功添加" + this.staffService.addStaff(staff) + "个员工";
		
		return s;
	}

	/**
	 * 修改员工;根据ID改名字
	 * 
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateStaff", method = RequestMethod.POST)
	public String updateStaff(@RequestBody DbStaff staff,HttpServletRequest request) {
		// TODO
		System.out.println("修改员工。。。" + staff.getStaff_department());
		System.out.println(JSON.toJSONString(staff));

		HttpSession session = request.getSession();

		DbStaff sessionStaff = (DbStaff) session.getAttribute("staff");
		if (sessionStaff == null) {
			System.out.println("没有员工信息");
		} else {
			System.out.println("当前的员工是" + JSON.toJSONString(sessionStaff));
		}
		String s="成功修改"+this.staffService.updateStaff(staff)+"个员工";
		return s;
	}

	/**
	 * 删除员工
	 * 
	 * @param staff
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteStaff", method = RequestMethod.POST)
	public String deleteStaff(@RequestBody DbStaff staff,HttpServletRequest request) {
		// TODO
		// System.out.println("删除员工。。。");
		// System.out.println(JSON.toJSONString(staff));
		// return "成功删除"+this.staffService.deleteStaff(staff)+"个员工";
		System.out.println(JSON.toJSONString(staff));
		this.staffService.deleteStaff(staff);
		String s= "成功删除";
		return s;
	}

}
