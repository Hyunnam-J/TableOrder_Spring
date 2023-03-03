package com.example.tableorder.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tableorder.mapper.TableOrderSettingMapper;

@Service
@Transactional
public class TableOrderSettingService {
	@Autowired TableOrderSettingMapper tableOrderSettingMapper;

	public String checkPassword(@Param("comId") String comId, @Param("pos") String pos) {
		return tableOrderSettingMapper.checkPassword(comId, pos);
	}
}
