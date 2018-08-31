package com.hrms.syh.transfer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.along.entity.DbTransfer;

public interface IDbTransferMapper {
	//查询
	//	List<DbTransfer> listTransfer(@Param("start")Integer start,@Param("count")Integer count);
		//插入
		int addTransfer(DbTransfer transfer);
		//删除
		int deleteTransfer(DbTransfer transfer);
		//修改
		int updateTransfer(DbTransfer transfer);
		//分页
		int getTransferCount();
		//根据ID查所有信息
		DbTransfer getTransferByID(String id);
		
		List<DbTransfer> listTransfer();
}
