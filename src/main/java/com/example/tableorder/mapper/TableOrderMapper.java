package com.example.tableorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.tableorder.vo.ItemVO;
import com.example.tableorder.vo.TabCodeVO;

@Mapper
@Repository
public interface TableOrderMapper {
	
	public List<TabCodeVO> tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos);
	public List<ItemVO> itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos);

}
