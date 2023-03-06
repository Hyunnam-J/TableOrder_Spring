package com.example.tableorder.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableorder.service.TableOrderBasketService;
import com.example.tableorder.vo.basket.BasketVO;
import com.example.tableorder.vo.basket.SendOrderVO;
import com.example.tableorder.vo.basket.SendPayVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@RestController
@RequestMapping("api/basket")
public class TableOrderBasketRestController {
	@Autowired TableOrderBasketService tableOrderBasketService;
	
	@PostMapping(value = "order")
	public String order(@RequestBody String sendOrderVO) throws ParseException {
		
		SendOrderVO vo = new Gson().fromJson(sendOrderVO, (Type) new TypeToken<SendOrderVO>() {}.getType());
		
		List<BasketVO> basketList = vo.getBasketList();
		int tNum = vo.gettNum();
		int subTotAmt = vo.getSubTotAmt();
		
		String result = "fail";
		try {
			tableOrderBasketService.order(basketList, tNum, subTotAmt);
			result = "success";
		} catch (Exception e) {
			
		}
		return result;
	}
	
	@PostMapping(value = "pay")
	public String pay(@RequestBody String sendPayVO) {
		
		SendPayVO vo = new Gson().fromJson(sendPayVO, (Type) new TypeToken<SendPayVO>() {}.getType());
		List<BasketVO> basketList = vo.getBasketList();
		int tNum = vo.gettNum();
		
		tableOrderBasketService.pay(basketList, tNum);
		
		return "";
	}
}	//class


