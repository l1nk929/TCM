package cn.link.tcm.mapper;

import cn.link.tcm.po.ZzguifanAttrVo;


public interface ZzguifanAttrVoMapper {

	public ZzguifanAttrVo findZzguifanAttrVoById(int id);

	public void deleteZzguifanAttrVo(ZzguifanAttrVo vo);
	
	public void addZzguifanAttrVo(ZzguifanAttrVo vo);
}
