package com.along.entity;

public class DbSalary {
	
	//工资表ID
	private String id;
	
	//员工姓名（db_staff）
	private String staff_name;
	
	//基础工资
	private float basic_wage;
	
	//绩效工资
	private float merit_pay;
	
	//奖惩工资
	private float rewards;
	
	//工资月份备注
	private String salary_date;
	
	//工资情况备注
	private String remarks;
	
	//删除状态判断
	private String isdelete;
	
	//员工姓名（db_staff）
	//private DbStaff name;
	
	//员工姓名
	private String staffName;
	
	private String name;

	
	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	//Get Set 方法
	
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	/*
	public DbStaff getName() {
		return name;
	}

	public void setName(DbStaff name) {
		this.name = name;
	}
	*/

	public void setId(String id) {
		this.id = id;
	}

	public float getBasic_wage() {
		return basic_wage;
	}

	public void setBasic_wage(float basic_wage) {
		this.basic_wage = basic_wage;
	}

	public float getMerit_pay() {
		return merit_pay;
	}

	public void setMerit_pay(float merit_pay) {
		this.merit_pay = merit_pay;
	}

	public float getRewards() {
		return rewards;
	}

	public void setRewards(float rewards) {
		this.rewards = rewards;
	}

	public String getSalary_date() {
		return salary_date;
	}

	public void setSalary_date(String salary_date) {
		this.salary_date = salary_date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}