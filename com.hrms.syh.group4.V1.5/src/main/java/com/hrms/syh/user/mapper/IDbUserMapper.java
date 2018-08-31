package com.hrms.syh.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.along.entity.DbUser;

public interface IDbUserMapper {
	List<DbUser> listUser();
	DbUser getUserByID(String id);
	int addUser(DbUser user);
	int updateUser(DbUser user);
	int deleteUser(DbUser user);
	int loginByUserNameAndPassword(DbUser user);
}
