package com.example.tableorder.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableorder.service.TableOrderMainService;
import com.example.tableorder.vo.main.MainItemVO;
import com.example.tableorder.vo.main.MainTabCodeVO;
import com.google.gson.Gson;

@RestController
@RequestMapping("api/main")
public class TableOrderMainRestController {
	@Autowired TableOrderMainService tableOrderMainService;

	@GetMapping(path = "tabMenu")
	public String tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos) {
		List<MainTabCodeVO> tabList = tableOrderMainService.tabMenu(comId, tabUse, pos);
		return new Gson().toJson(tabList);
	}
		
	@GetMapping(path = "itemMenu")
	public String itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos) {
		List<MainItemVO> itemList = tableOrderMainService.itemMenu(comId, pCode, pos);
		return new Gson().toJson(itemList);
	}
}
