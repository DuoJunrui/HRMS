package com.hrms.syh.department.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.along.entity.DbDepartment;

public interface IDbDepartmentMapper {
	List<DbDepartment> listDepartment();
	int addDepartment(DbDepartment dept);
	int updateDepartment(DbDepartment dept);
	int deleteDepartment(DbDepartment dept);
}
