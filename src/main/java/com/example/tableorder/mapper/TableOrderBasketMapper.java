package com.example.tableorder.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface TableOrderBasketMapper {

	public int checkTMenuSeq(int tNum);
	public int checkOrderNo();
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
}
