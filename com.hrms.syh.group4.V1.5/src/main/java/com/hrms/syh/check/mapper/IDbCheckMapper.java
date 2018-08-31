package com.hrms.syh.check.mapper;

import java.util.List;

import com.along.entity.DbCheck;
import com.along.entity.DbUser;

public interface IDbCheckMapper {
	
	//查询考勤表
	List<DbCheck> listCheck();
	
	//增加考勤表
	boolean addCheck(DbCheck dbCheck);
	
	//修改考勤表
	boolean updateCheck(DbCheck dbCheck);
	
	//删除考勤表
	boolean deleteCheck(DbCheck dbCheck);
	
	//通过用户名和密码获取用户id
	DbUser getIdByAccountAndPassword(DbUser dbUser);
}
