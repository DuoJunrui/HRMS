package com.hrms.syh.department.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.along.entity.DbDepartment;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.department.mapper.IDbDepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	private IDbDepartmentMapper deptMapper;
	
	public List<DbDepartment> listDepartment()
	{
		return this.deptMapper.listDepartment();
	}
	
	public int addDepartment(DbDepartment dept)
	{	
		dept.setId(UUIDUtil.createUUID());
		dept.setIsdelete("0");
		return this.deptMapper.addDepartment(dept);
	}
	
	public boolean updateDepartment(DbDepartment dept)
	{
		return this.deptMapper.updateDepartment(dept)>0;
	}
	
	public int deleteDepartment(DbDepartment dept)
	{
		return this.deptMapper.deleteDepartment(dept);
	}
}
