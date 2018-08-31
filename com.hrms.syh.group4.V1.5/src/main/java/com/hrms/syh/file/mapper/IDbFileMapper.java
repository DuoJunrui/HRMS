package com.hrms.syh.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.along.entity.DbFile;



public interface IDbFileMapper {
	//查询
	List<DbFile> listFile();
	//插入
	int addFile(DbFile file);
	//删除
	int deleteFile(DbFile file);
	//修改
	int updateFile(DbFile file);
	//分页
	int getFileCount();
	//根据ID查所有信息
	DbFile getFileByID(String id);
}
