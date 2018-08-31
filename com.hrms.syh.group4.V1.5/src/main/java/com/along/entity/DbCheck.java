package com.along.entity;

import com.common.hrms.UUIDUtil;

public class DbCheck {
	
	public DbCheck() {
		//设置考勤表记录id
		id = UUIDUtil.createUUID();
		//设置考勤时间
		office_time = "08:30:00";
		//设置默认删除状态
		isdelete = "0";
	}
	
	//考勤表ID
	private String id;
	
	//员工姓名(db_staff)
	private String staff_name;
	
	//工作时间(由上级规定上班时间，时分秒)
	private String office_time;
	
	//签到日期(年月日)(签到点击触发，自动生成)
	private String check_day;
	
	//签到时间(时分秒)(签到点击触发，自动生成)
	private String check_time;
	
	//考勤情况(早到、迟到、未到、请假)(通过计算时间差，填入相应情况)
	private String check_case;

	//职工姓名
	private String name;
	
	//删除状态
	private String isdelete;
	
	
	
	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getOffice_time() {
		return office_time;
	}

	public void setOffice_time(String office_time) {
		this.office_time = office_time;
	}

	public String getCheck_day() {
		return check_day;
	}

	public void setCheck_day(String check_day) {
		this.check_day = check_day;
	}

	public String getCheck_time() {
		return check_time;
	}

	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}

	public String getCheck_case() {
		return check_case;
	}

	public void setCheck_case(String check_case) {
		this.check_case = check_case;
	}
	
	
	
}
