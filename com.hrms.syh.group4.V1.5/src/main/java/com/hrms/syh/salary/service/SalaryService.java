package com.hrms.syh.salary.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.along.entity.DbSalary;
import com.along.entity.DbStaff;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.salary.mapper.IDbSalaryMapper;
import com.hrms.syh.staff.mapper.IDbStaffMapper;

/**
 * 
 * @author 多俊睿
 * @date 2018年8月27日 下午1:46:36 
 *
 */


@Service
public class SalaryService {
	
	@Autowired
	private IDbSalaryMapper salaryMapper;
	@Autowired
	private IDbStaffMapper staffMapper;
	
	
	//添加工资记录
	@Transactional
	public int insertSalary(DbSalary salary) {

		salary.setId(UUIDUtil.createUUID());
		salary.setIsdelete("0");
		
		return this.salaryMapper.insertSalary(salary);

	}
	
	//根据ID删除工资单
		@Transactional
		public int deleteSalary(DbSalary salary) {
			return this.salaryMapper.deleteSalary(salary);
		}
	
	//根据ID修改工资单
	@Transactional
	public int updateSalary(DbSalary salary) {

		return this.salaryMapper.updateSalary(salary);
	}
	
	//查询所有工资记录
	@Transactional
	public List<DbSalary> selectSalary() {
		// TODO
		return this.salaryMapper.selectSalary();
	}

}
