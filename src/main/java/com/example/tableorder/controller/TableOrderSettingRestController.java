package com.example.tableorder.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableorder.service.TableOrderSettingService;

@RestController
@RequestMapping("api/setting")
public class TableOrderSettingRestController {
	@Autowired TableOrderSettingService tableOrderSettingService;
	
	@GetMapping(path = "checkPassword")
	public String checkPassword(@Param("comId") String comId, @Param("pos") String pos) {
		return tableOrderSettingService.checkPassword(comId, pos);
	}

}
