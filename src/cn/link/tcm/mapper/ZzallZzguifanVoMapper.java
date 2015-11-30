package cn.link.tcm.mapper;

import cn.link.tcm.po.ZzallZzguifanVo;

public interface ZzallZzguifanVoMapper {

	public ZzallZzguifanVo findZzallZzguifanVoById(int id);
	
	public void deleteZzallZzguifanVo(ZzallZzguifanVo vo);
	
	public void addZzallZzguifanVo(ZzallZzguifanVo vo);
	
	//public void updateZzallZzguifanVo(ZzallZzguifanVo vo);
}
