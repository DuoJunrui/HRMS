package com.hrms.syh.staff.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.along.entity.DbStaff;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.staff.mapper.IDbStaffMapper;

@Service
public class StaffService {
	@Autowired
	private IDbStaffMapper staffMapper;

	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	public List<DbStaff> listStaff() {
		
		return this.staffMapper.listStaff();
	}

	/**
	 * 统计员工数量
	 * 
	 * @return
	 */
	public int getStaffCount() {
		// TODO
		return this.staffMapper.getStaffCount();
	}

	/**
	 * 添加员工（员工入职）
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int addStaff(DbStaff staff) {
		// TODO
		// 新增记录
		staff.setId(UUIDUtil.createUUID());
		staff.setIsdelete("0");
		return this.staffMapper.addStaff(staff);
	}

	/**
	 * 修改员工 
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int updateStaff(DbStaff staff) {
		// TODO
		// 修改记录
		// TODO
		if (staff.getId() == null) {
			return 0;
		}
		return this.staffMapper.updateStaff(staff);
	}

	/**
	 * 删除员工
	 * 
	 * @param staff
	 * @return
	 */
	@Transactional
	public int deleteStaff(DbStaff staff) {
		// TODO
		if (staff.getId() == null) {
			return 0;
		}
		return this.staffMapper.deleteStaff(staff);
	}

}
