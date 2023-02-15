package com.example.tableorder.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableorder.service.TableOrderService;
import com.example.tableorder.vo.ItemVO;
import com.example.tableorder.vo.TabCodeVO;
import com.google.gson.Gson;

@RestController
public class TableOrderRestController {
	@Autowired TableOrderService tableOrderService;

	@GetMapping(path = "api/tabMenu")
	public String tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos) {
		List<TabCodeVO> tabList = tableOrderService.tabMenu(comId, tabUse, pos);
		return new Gson().toJson(tabList);
	}
	
	@GetMapping(path = "api/itemMenu")
	public String itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos) {
		List<ItemVO> menuList = tableOrderService.itemMenu(comId, pCode, pos);
		return new Gson().toJson(menuList);
	}
}
