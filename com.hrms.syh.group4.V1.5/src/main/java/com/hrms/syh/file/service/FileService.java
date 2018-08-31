package com.hrms.syh.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.along.entity.DbFile;
import com.common.hrms.UUIDUtil;
import com.hrms.syh.file.mapper.IDbFileMapper;

@Service
public class FileService {
	 @Autowired
	 private IDbFileMapper fileMapper;
	 /**
		 * 查询所有制度信息
		 * 
		 * @return
		 */
	 @Transactional
	 public List<DbFile> listFile(){
		 return this.fileMapper.listFile();
	 }
	 /**
		 * 添加制度信息
		 * 
		 * @return
		 */
	 @Transactional
	 public int addFile(DbFile file) {
		 //新增记录
		 file.setId(UUIDUtil.createUUID());
		 file.setFile_name(file.getFile_name());
		 file.setFile_content(file.getFile_content());
		 file.setPost_time(System.currentTimeMillis());
		 file.setIsdelete("0");
		 return this.fileMapper.addFile(file);
	 
	 }
	 /**
		 * 更新制度信息
		 * 
		 * @return
		 */
	 public boolean updateFile(DbFile file) {
		 return this.fileMapper.updateFile(file)>0;
	 }
	 
	 /**
		 * 删除制度信息
		 * 
		 * @return
		 */
	 public int deleteFile(DbFile file) {
		 if(file.getId()==null) {
			 return 0;
		 }
		 return this.fileMapper.deleteFile(file);
	 }
	 /**
		 * 分页制度信息
		 * 
		 * @return
		 */
	 public int getFileCount() {
		 return this.fileMapper.getFileCount();
	 }
	 /**
		 * 根据ID查制度信息
		 * 
		 * @return
		 */
	 
	 public DbFile getFileByID(String id) {
		 return this.fileMapper.getFileByID(id);
	 }
}
