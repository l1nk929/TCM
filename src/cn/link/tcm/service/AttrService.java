package cn.link.tcm.service;

import java.util.List;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.ZzguifanAttrVo;

public interface AttrService {

	public ZzguifanAttrVo findZzguifanAttrVoById(int id);
	
	public List<AttrallListVo> findParentsByAttrall(List<Attrall> list);
}
