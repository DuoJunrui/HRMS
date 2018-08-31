package com.hrms.syh.salary.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.along.entity.DbSalary;

/**
 * 
 * @author 多俊睿
 * @date 2018年8月27日 上午0:26:37 
 *
 */

public interface IDbSalaryMapper {

	//添加工资记录
	int insertSalary(@Param("salary") DbSalary salary);
	
	//根据ID删除工资单
	int deleteSalary(DbSalary salary);
	
	//根据员工姓名修改工资信息
	int updateSalary(DbSalary salary);

	//查询所有工资信息
	List<DbSalary> selectSalary();
	
}
