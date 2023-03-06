package com.example.tableorder.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
			int tempOrderNo = tableOrderBasketMapper.checkTableDetailOrderNo()+1;
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
	
	public void pay(List<BasketVO> basketList, int tNum) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String salDate = sdf.format(new Date());
		
		int salSeq = 1;
		
		try {
			int temp = tableOrderBasketMapper.checkSalSeq(salDate);
			salSeq = temp + 1;
		} catch (Exception e) {

		}
		
		LocalTime nowTime = LocalTime.now();
		String trTime = nowTime.getHour()+nowTime.getMinute()+nowTime.getSecond()+"";
		
		
		
		
		//메뉴 종목 수별로 들어가야 된다
		String tCode = "1";
		
		try {
			String temp = tableOrderBasketMapper.checkTmtktDetailTcode(salDate, basketList.get(0).getPos());
			tCode = Integer.parseInt(temp) + 1 + "";
		} catch (Exception e) {
			tCode = salDate.substring(2) + basketList.get(0).getPos() + String.format("%06d", salSeq);
		}
		
		
		
		
		
		
		
		
		String orderNo = "0001";
		try {
			int tempOrderNo = tableOrderBasketMapper.checkTmtktDetailOrderNo(salDate)+1;
			orderNo = String.format("%04d", tempOrderNo);
		}catch (Exception e) {
			
		}
		
		String chCode = "SYSTEM";
		String aPayment = "01";
		String groupSel = "0";
		int rePrint = 0;
		String aReturn = "0";
		String rtnSalDt = "N";
		String rtnDate = "N";
		String rtnTime = "N";
		String rtnCh = "N";
		String rtnPos = "N";
		String servTrans = "N";
		String transDate = "N";
		String transTime = "N";
		String rtnSvrSend = "N";
		String timeSeq = null;
		String bsend = null;
		String btReturn = null;
		String bt_Orderno = null;
		String refundrs = "N";
		String agreeNo = null;
		Date rDate = new Date();
		Date uDate = null;
		String lockNum = "N";
		
		
		for(int i=0; i<basketList.size(); i++) {
			tableOrderBasketMapper.insertTmtktDetail(
					basketList.get(i).getComId(), 
					salDate, 
					basketList.get(i).getPos(), 
					salSeq, 
					tCode, 
					i+1, 
					basketList.size(), 
					salDate, 
					trTime, 
					chCode, 
					basketList.get(i).getItemCode(), 
					basketList.get(i).getpCode(), 
					basketList.get(i).getuPrice(), 
					basketList.get(i).getQuantity(), 
					basketList.get(i).getuPrice()*basketList.get(i).getQuantity(), 
					aPayment, 
					groupSel, 
					rePrint, 
					aReturn, 
					rtnSalDt, 
					rtnDate, 
					rtnTime,
					rtnCh,
					rtnPos, 
					servTrans, 
					transDate, 
					transTime, 
					rtnSvrSend, 
					timeSeq, 
					bsend, 
					btReturn, 
					bt_Orderno, 
					refundrs, 
					agreeNo, 
					rDate, 
					uDate, 
					lockNum, 
					orderNo, 
					basketList.get(i).getSubUse(), 
					basketList.get(i).getuPrice(), 
					tNum
					);
		}	//for(int i=0; i<basketList.size(); i++) 
	}	//pay
}	//class
