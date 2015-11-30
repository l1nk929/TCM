package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.Zzall;

public interface ZzallMapper {

	public Zzall findZzallById(int id)throws Exception;
	
	public List<Zzall> findAllZzall();
	
	public void updateZzallType(Zzall zzall);
	
	
}
