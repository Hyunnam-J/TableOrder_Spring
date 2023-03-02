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
		
		Resp<MainTabCodeVO> resp;
		
		try {
			List<MainTabCodeVO> tabList = tableOrderMainService.tabMenu(comId, tabUse, pos);
			resp = new Resp<>(0, "success", tabList);
		} catch (Exception e) {
			resp = new Resp<>(-1, "fail : "+e, null);
		}
		
		return new Gson().toJson(resp);
	}
		
	@GetMapping(path = "itemMenu")
	public String itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos) {
		
		Resp<MainItemVO> resp;
		
		try {
			List<MainItemVO> itemList = tableOrderMainService.itemMenu(comId, pCode, pos);
			resp = new Resp<>(0, "success", itemList);

		} catch (Exception e) {
			resp = new Resp<>(-1, "fail : "+e, null);
		}
		
		return new Gson().toJson(resp);
	}
}
