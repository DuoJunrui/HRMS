package com.along.entity;

import java.sql.Date;

public class DbTransfer {
       private String id;
       private String staff_name;
       private String old_department;
       private String new_department;
       private Date transfer_time;
       private String name;
       private String department_name;
       private String olddp;
       private String newdp;
       private String isdelete;
       public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	public String getOlddp() {
		return olddp;
	}
	public void setOlddp(String olddp) {
		this.olddp = olddp;
	}
	public String getNewdp() {
		return newdp;
	}
	public void setNewdp(String newdp) {
		this.newdp = newdp;
	}
	
      // private String department_name1;
    
       /*
	public String getDepartment_name1() {
		return department_name1;
	}
	public void setDepartment_name1(String department_name1) {
		this.department_name1 = department_name1;
	}
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
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
	public String getOld_department() {
		return old_department;
	}
	public void setOld_department(String old_department) {
		this.old_department = old_department;
	}
	public String getNew_department() {
		return new_department;
	}
	public void setNew_department(String new_department) {
		this.new_department = new_department;
	}
	public Date getTransfer_time() {
		return transfer_time;
	}
	public void setTransfer_time(Date transfer_time) {
		this.transfer_time = transfer_time;
	}
	
       
}
