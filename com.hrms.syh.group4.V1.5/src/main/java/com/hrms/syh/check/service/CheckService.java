package com.hrms.syh.check.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.along.entity.DbCheck;
import com.along.entity.DbUser;
import com.hrms.syh.check.mapper.IDbCheckMapper;

@Service
public class CheckService {
	
	@Autowired
	private IDbCheckMapper checkMapper;
	
	//查询考勤表
	public List<DbCheck> listCheck(){
		return this.checkMapper.listCheck();
	}
	
	//增加考勤表记录 
	public boolean addCheck(DbCheck dbCheck) {
		
		//年月日
		Date date = new Date();
		String check_day = new SimpleDateFormat("yyyy-MM-dd").format(date).toString();
		dbCheck.setCheck_day(check_day);
		//时分秒
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		String check_time = simpleDateFormat.format(date).toString();
		dbCheck.setCheck_time(check_time);
		//考勤情况
		try {
			 long result = simpleDateFormat.parse(check_time).getTime() - simpleDateFormat.parse(dbCheck.getOffice_time()).getTime();
			 if (result > 0) {
				dbCheck.setCheck_case("迟到");
			} else {
				dbCheck.setCheck_case("早到");
			}
		} catch (ParseException e) {
			// TODO: handle exception
		}
		return this.checkMapper.addCheck(dbCheck);
	}
	
	//修改考勤表记录
	public boolean updateCheck(DbCheck dbCheck) {
		return this.checkMapper.updateCheck(dbCheck);
	}
	
	//删除考勤表记录
	public boolean deleteCheck(DbCheck dbCheck) {
		return this.checkMapper.deleteCheck(dbCheck);
	}
	
	public DbUser getIdByAccountAndPassword(DbUser dbUser) {
		return this.checkMapper.getIdByAccountAndPassword(dbUser);
	}
}
