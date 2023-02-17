package com.example.tableorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.tableorder.vo.main.MainItemVO;
import com.example.tableorder.vo.main.MainTabCodeVO;

@Mapper
@Repository
public interface TableOrderMainMapper {
	
	public List<MainTabCodeVO> tabMenu(@Param("comId") String comId, @Param("tabUse") String tabUse, @Param("pos") String pos);
	public List<MainItemVO> itemMenu(@Param("comId") String comId, @Param("pCode") String pCode, @Param("pos") String pos);

}
