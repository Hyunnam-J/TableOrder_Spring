package com.example.tableorder.mapper;


import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TableOrderBasketMapper {

	public Integer checkTMenuSeq(int tNum);
	public Integer checkTableDetailOrderNo();
	public int order(
			
			@Param("tNum") int tNum,
			@Param("tMenuSeq") int tMenuSeq,
			@Param("tabNo") String tabNo,
			@Param("itemNo") String itemNo,
			@Param("pName") String pName,
			@Param("itemName1") String itemName1,
			@Param("itemName2") String itemName2,
			@Param("pCode") String pCode,
			@Param("itemCode") String itemCode,
			@Param("uPrice") int uPrice,		//Aunit
			@Param("quantity") int quantity,	//Anum
			@Param("aAmt") int aAmt,
			@Param("tax") String tax,
			@Param("sex") String sex,
			@Param("area") String area,
			@Param("stock") int stock,
			@Param("stockUse") String stockUse,
			@Param("subUse") String subUse,
			@Param("subTotAmt") int subTotAmt, 
			@Param("oPrice") int oPrice,
			@Param("orderNo") String orderNo
			
			);
	
	
	
	
	
	
	public Integer checkSalSeq(@Param("salDate") String salDate);
	
	public Integer checkTmtktDetailOrderNo(@Param("salDate") String salDate);
	
	public String checkTmtktDetailTcode(@Param("salDate") String salDate, @Param("pos") String pos);
	
	public int insertTmtktDetail(
			
			@Param("comId") String comId,
			@Param("salDate") String salDate,
			@Param("salPos") String salPos,
			@Param("salSeq") int salSeq,
			@Param("tCode") String tCode,
			@Param("tkdtSeq") int tkdtSeq,
			@Param("tkdtTot") int tkdtTot,
			@Param("trDate") String trDate,
			@Param("trTime") String trTime,
			@Param("chCode") String chCode,
			@Param("itemCode") String itemCode,
			@Param("pCode") String pCode,
			@Param("aUnit") int aUnit,
			@Param("aNum") int aNum,
			@Param("aAmt") int aAmt,
			@Param("aPayment") String aPayment,
			@Param("groupSel") String groupSel,
			@Param("rePrint") int rePrint,
			@Param("aReturn") String aReturn,
			@Param("rtnSalDt") String rtnSalDt,
			@Param("rtnDate") String rtnDate,
			@Param("rtnTime") String rtnTime,
			@Param("rtnCh") String rtnCh,
			@Param("rtnPos") String rtnPos,
			@Param("servTrans") String servTrans,
			@Param("transDate") String transDate,
			@Param("transTime") String transTime,
			@Param("rtnSvrSend") String rtnSvrSend,
			@Param("timeSeq") String timeSeq,
			@Param("bsend") String bsend,
			@Param("btReturn") String btReturn,
			@Param("bt_Orderno") String bt_Orderno,
			@Param("refundrs") String refundrs,
			@Param("agreeNo") String agreeNo,
			@Param("rDate") Date rDate,
			@Param("uDate") Date uDate,
			@Param("lockNum") String lockNum,
			@Param("orderNo") String orderNo,
			@Param("subUse") String subUse,
			@Param("baseUnit") int baseUnit,
			@Param("tNum") int tNum
			
			);
	
	
	
	
	
	public int insertTmtktHdr(
			
			@Param("salDate") String salDate,
			@Param("salPos") String salPos,
			@Param("salSeq") int salSeq,
			@Param("trDate") String trDate,
			@Param("trTime") String trTime,
			@Param("chCode") String chCode,
			@Param("totCnt") int totCnt,
			@Param("totAmt") int totAmt,
			@Param("aReturn") String aReturn,
			@Param("cashGbn") String cashGbn,
			@Param("cashRcp") String cashRcp,
			@Param("cashRcpApp") String cashRcpApp,
			@Param("cashAmt") int cashAmt,
			@Param("cashInputNo") String cashInputNo,
			@Param("rtnSalDt") String rtnSalDt,
			@Param("rtnDate") String rtnDate,
			@Param("rtnTime") String rtnTime,
			@Param("rtnCh") String rtnCh,
			@Param("rtnPos") String rtnPos,
			@Param("servTrans") String servTrans,
			@Param("rtnSvrSend") String rtnSvrSend,
			@Param("transDate") String transDate,
			@Param("transTime") String transTime,
			@Param("tidNo") String tidNo,
			@Param("cashCustomerGbn") String cashCustomerGbn,
			@Param("comId") String comId,
			@Param("rDate") Date rDate,
			@Param("uDate") Date uDate
			
			);
}
