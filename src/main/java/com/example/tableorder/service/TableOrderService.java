package com.example.tableorder.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tableorder.mapper.TableOrderMapper;
import com.example.tableorder.vo.ItemVO;
import com.example.tableorder.vo.TabCodeVO;

@Service
@Transactional
public class TableOrderService {
	@Autowired TableOrderMapper tableOrderMapper;
		
	public List<TabCodeVO> tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos) {
		return tableOrderMapper.tabMenu(comId, tabUse, pos);
	}
	
	public List<ItemVO> itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos){
		return tableOrderMapper.itemMenu(comId, pCode, pos);
		
	}
	
	

}
