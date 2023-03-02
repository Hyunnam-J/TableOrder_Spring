package com.example.tableorder.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tableorder.mapper.TableOrderMainMapper;
import com.example.tableorder.vo.main.MainItemVO;
import com.example.tableorder.vo.main.MainTabCodeVO;

@Service
@Transactional
public class TableOrderMainService {
	@Autowired TableOrderMainMapper tableOrderMainMapper;
		
	public List<MainTabCodeVO> tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos) throws Exception {
		
		List<MainTabCodeVO> tabList = tableOrderMainMapper.tabMenu(comId, tabUse, pos);
		
		if(tabList.size()==0) {
			throw new Exception("관련 데이터가 없습니다.");
		}
		
		return tabList;
	}
	
	public List<MainItemVO> itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos) throws Exception{
		
		List<MainItemVO> itemList = tableOrderMainMapper.itemMenu(comId, pCode, pos);
		
		if(itemList.size()==0) {
			throw new Exception("관련 데이터가 없습니다.");
		}
		
		return itemList;
	}
}
