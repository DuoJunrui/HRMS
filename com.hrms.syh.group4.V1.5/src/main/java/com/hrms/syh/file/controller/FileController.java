package com.hrms.syh.file.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.along.entity.DbFile;

import com.hrms.syh.file.service.FileService;



@Controller
@RequestMapping(value = "file")
public class FileController {
	 @Autowired
	 private FileService fileService;
	 /**
 	 * 根据ID查询制度
 	 */
	 @ResponseBody
	 @RequestMapping(value = "getFileByID", method = RequestMethod.GET)
	 public String getFileByID(String id) {
		 return JSON.toJSONString(this.fileService.getFileByID(id));
	 }
	 /**
	 	 * 查询所有信息，
	 	 */
	 @ResponseBody
	 @RequestMapping(value = "listFile", method = RequestMethod.GET)
	 public String listFile() {
		return JSON.toJSONString(this.fileService.listFile());
	 }
	 
	 /**
	 * 添加制度
	 */
	@ResponseBody
 	@RequestMapping(value = "addFile", method = RequestMethod.POST)
	 public String addFile(@RequestBody DbFile file) {
		 System.out.println("********添加制度*********");
		 System.out.println(JSON.toJSONString(file));
		 return "成功添加"+this.fileService.addFile(file)+"制度文件";
	 }
	 /**
		 * 更新制度，根据ID改制度内容
		 */
	@ResponseBody
	@RequestMapping(value = "updateFile", method = RequestMethod.POST)
	 public String updateFile(@RequestBody DbFile file,HttpServletRequest request, HttpServletResponse response) {
		 Map<String ,String> reslut = new HashMap<>();
		 if(this.fileService.updateFile(file)) {
			 reslut.put("msg", "制度文件已经修改为"+file.getFile_content());
		 }
		 else {
			 reslut.put("msg", "制度文件修改失败");
		 }
		 return JSON.toJSONString(reslut);
	 }
	 /**
		 * 删除制度，根据ID删除
		 */
	@ResponseBody
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	 public String deleteFile(@RequestBody DbFile file) {
		 int count=this.fileService.deleteFile(file);
		 Map<String ,String> reslut = new HashMap<>();
 		if(count>0)
 		{
 			reslut.put("msg", "删除成功了"+file.getId());
 		}else {
 			reslut.put("msg", "删除失败");
 		}
 		return JSON.toJSONString(reslut);
	 }
}
