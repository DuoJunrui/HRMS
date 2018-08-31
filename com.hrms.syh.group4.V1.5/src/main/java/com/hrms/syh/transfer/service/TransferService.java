package com.hrms.syh.transfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.along.entity.DbFile;
import com.along.entity.DbTransfer;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.transfer.mapper.IDbTransferMapper;

@Service
public class TransferService {
	 @Autowired
	 private IDbTransferMapper transferMapper;
	 /**
		 * 查询所有人事调动
		 * 
		 * @return
		 */
	 public List<DbTransfer> listTransfer(){
			return this.transferMapper.listTransfer();
			 
		 }
	 /**
		 * 添加人事调动
		 * 
		 * @return
		 */
	 @Transactional
	 public boolean addTransfer(DbTransfer transfer) {
		//新增记录
		 transfer.setId(UUIDUtil.createUUID());
		 //transfer.setStaff_name(transfer.getStaff_name());
		 //transfer.setOld_department(transfer.getOld_department());
		 //transfer.setNew_department(transfer.getNew_department());
		 //transfer.setTransfer_time(transfer.getTransfer_time());;
		 transfer.setIsdelete("0");
		 
		 
		 return this.transferMapper.addTransfer(transfer)>0;
	 }
	
	 
	 /**
		 * 更新人事调动
		 * 
		 * @return
		 */
	 public boolean updateTransfer(DbTransfer transfer) {
		 return this.transferMapper.updateTransfer(transfer)>0;
	 }
	 
	 /**
		 * 删除人事调动
		 * 
		 * @return
		 */
	 public int deleteTransfer(DbTransfer transfer) {
		 if(transfer.getId()==null) {
			 return 0;
		 }
		 return this.transferMapper.deleteTransfer(transfer);
	 }
	 /**
		 * 分页人事调动
		 * 
		 * @return
		 */
	 public int getTransferCount() {
		 return this.transferMapper.getTransferCount();
	 }
	 /**
		 * 根据ID查人事调动
		 * 
		 * @return
		 */
	 public DbTransfer getTransferByID(String id) {
		 return this.transferMapper.getTransferByID(id);
	 }
	 
}
