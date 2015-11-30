package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Zzall;

public interface ZzallService {

	public List<Zzall> findZzallByType(int type);
}
