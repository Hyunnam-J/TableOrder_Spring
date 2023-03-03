package com.example.tableorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TableOrderSettingMapper {
	
	public String checkPassword(@Param("comId") String comId, @Param("pos") String pos);

}
