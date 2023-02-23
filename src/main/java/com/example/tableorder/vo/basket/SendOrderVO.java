package com.example.tableorder.vo.basket;

import java.util.List;


public class SendOrderVO {

	List<BasketVO> basketList;
    int tNum, subTotAmt;
    
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
	public int getSubTotAmt() {
		return subTotAmt;
	}
	public void setSubTotAmt(int subTotAmt) {
		this.subTotAmt = subTotAmt;
	}
}
