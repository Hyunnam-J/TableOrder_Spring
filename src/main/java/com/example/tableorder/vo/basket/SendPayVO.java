package com.example.tableorder.vo.basket;

import java.util.List;

public class SendPayVO {
	
	List<BasketVO> basketList;
	int tNum;
	
	public List<BasketVO> getBasketList() {
		return basketList;
	}
	public void setBasketList(List<BasketVO> basketList) {
		this.basketList = basketList;
	}
	public int gettNum() {
		return tNum;
	}
	public void settNum(int tNum) {
		this.tNum = tNum;
	}

}
