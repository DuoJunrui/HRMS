package com.hrms.syh.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.along.entity.DbUser;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.user.mapper.IDbUserMapper;

@Service
public class UserService {
	@Autowired
	private IDbUserMapper userMapper;
	
	public List<DbUser> listUser()
	{
		return this.userMapper.listUser();
	}

	public int addUser(DbUser user)
	{	
		Date date =new Date();
		String creat_time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date).toString();
		user.setId(UUIDUtil.createUUID());
		user.setCreat_time(creat_time);
		user.setIsdelete("0");
		
		return this.userMapper.addUser(user);
	}
	
	public boolean updateUser(DbUser user)
	{
		return this.userMapper.updateUser(user)>0;
	}
	
	public int deleteUser(DbUser user)
	{
		return this.userMapper.deleteUser(user);
	}
	
	public boolean loginByUserNameAndPassword(DbUser user)
	{
		//TODO
		return this.userMapper.loginByUserNameAndPassword(user)>0;
	}
}
