package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.ZzallMapper;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.service.ZzallService;

public class ZzallServiceImpl implements ZzallService {

	@Autowired
	private ZzallMapper zzallMapper;
	
	@Override
	public List<Zzall> findZzallByType(int type) {
		List<Zzall> tempList = new ArrayList<Zzall>();
		
		List<Zzall> list = zzallMapper.findAllZzall();
		for(Zzall zzall:list){
			if(zzall.getType()==type)
				tempList.add(zzall);
		}
		
		
		return tempList;
		
	}

}
