package com.example.tableorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tableorder.mapper.TableOrderBasketMapper;
import com.example.tableorder.vo.basket.BasketVO;

@Service
@Transactional
public class TableOrderBasketService {
	@Autowired TableOrderBasketMapper tableOrderBasketMapper;
		
	public void order(List<BasketVO> basketList, int tNum, int subTotAmt) {
		
		int tMenuSeq = 1;
		
		try {
			tMenuSeq = tableOrderBasketMapper.checkTMenuSeq(tNum) + 1;
		}catch (Exception e) {
			
		}
		
		String itemNo = "0";
		
		String orderNo = "0001";
		try {
			int tempOrderNo = tableOrderBasketMapper.checkOrderNo()+1;
			orderNo = String.format("%04d", tempOrderNo);
		}catch (Exception e) {
			
		}
		
		int result = 0;
		for(int i=0; i<basketList.size(); i++) {
			result += tableOrderBasketMapper.order(
					
					tNum,
					tMenuSeq,
					basketList.get(i).getTabNo(),
					itemNo,
					basketList.get(i).getpName(),
					basketList.get(i).getItemName1(),
					basketList.get(i).getItemName2(),
					basketList.get(i).getpCode(),
					basketList.get(i).getItemCode(),
					basketList.get(i).getuPrice(),
					basketList.get(i).getQuantity(),
					basketList.get(i).getQuantity()*basketList.get(i).getuPrice(),	//aAmt
					basketList.get(i).getTax(),
					basketList.get(i).getSex(),
					basketList.get(i).getArea(),
					basketList.get(i).getStock(),
					basketList.get(i).getStockUse(),
					basketList.get(i).getSubUse(),
					subTotAmt,
					basketList.get(i).getuPrice(),
					orderNo
					
					);
		}
	}	//order
}	//class
