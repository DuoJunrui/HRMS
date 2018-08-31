package com.hrms.syh.staff.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.along.entity.DbStaff;

public interface IDbStaffMapper {
	
	//分页查询所有员工
	List<DbStaff> listStaff();
	
	//统计员工数量
	int getStaffCount();
	
	//添加员工信息（员工入职）
	int addStaff(@Param("st")DbStaff staff);
	
	//修改员工信息（通过ID）
	int updateStaff(DbStaff staff);
	
	//删除员工信息（通过ID）
	int deleteStaff(DbStaff staff);
}
