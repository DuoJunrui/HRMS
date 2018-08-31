package com.hrms.syh.transfer.controller;



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

import com.along.entity.DbTransfer;

import com.hrms.syh.transfer.service.TransferService;



@Controller
@RequestMapping(value = "transfer")
public class TransferController {
	 @Autowired
	 private TransferService transferService;
	 /**
	 	 * 根据ID人事调动
	 	 */
	 @ResponseBody
	 @RequestMapping(value = "getTransferByID", method = RequestMethod.GET)
	 public String getTransferByID(String id) {
		 return JSON.toJSONString(this.transferService.getTransferByID(id));
	 }
	 /**
	 	 * 查询所有信息
	 	 */
	 @ResponseBody
	 @RequestMapping(value = "listTransfer", method = RequestMethod.GET)
	 public String listTransfer() {
		return JSON.toJSONString(this.transferService.listTransfer());
	 }
	 
	 
	 
	 
	
	
	 
	 /**
		 * 添加人事调动
		 */
		@ResponseBody
	 	@RequestMapping(value = "addTransfer", method = RequestMethod.POST)
		 public String addTransfer(@RequestBody DbTransfer transfer) {
			Map<String,String> result =new HashMap<>();
			if(this.transferService.addTransfer(transfer)) {
				result.put("msg", "添加成功"+transfer.getId()+transfer.getNew_department()+transfer.getOld_department()+transfer.getStaff_name());
			}
			else {
				result.put("msg", "删除成功");
			}
			
			 return JSON.toJSONString(result);
		 }
		 /**
			 * 更新人事调动，根据ID改制度内容
			 */
		@ResponseBody
		@RequestMapping(value = "updateTransfer", method = RequestMethod.POST)
		 public String updateTransfer(@RequestBody DbTransfer transfer,HttpServletRequest request, HttpServletResponse response) {
			 Map<String ,String> reslut = new HashMap<>();
			 if(this.transferService.updateTransfer(transfer)) {
				 reslut.put("msg", "部门已经修改为"+transfer.getNew_department());
			 }
			 else {
				 reslut.put("msg", "部门修改失败");
			 }
			 return JSON.toJSONString(reslut);
		 }
		 /**
			 * 删除人事调动，根据ID删除
			 */
		@ResponseBody
		@RequestMapping(value = "deleteTransfer", method = RequestMethod.POST)
		 public String deleteTransfer(@RequestBody DbTransfer transfer) {
			 int count=this.transferService.deleteTransfer(transfer);
			 Map<String ,String> reslut = new HashMap<>();
	 		if(count>0)
	 		{
	 			reslut.put("msg", "删除成功了"+transfer.getId());
	 		}else {
	 			reslut.put("msg", "删除失败");
	 		}
	 		return JSON.toJSONString(reslut);
		 }
		 
		 
		 
		
}
