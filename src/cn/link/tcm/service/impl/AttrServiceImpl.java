package cn.link.tcm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;

import cn.link.tcm.mapper.AttrallMapper;
import cn.link.tcm.mapper.ZzguifanAttrVoMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallLevel;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.service.AttrService;

public class AttrServiceImpl implements AttrService{

	@Autowired
	private ZzguifanAttrVoMapper zzguifanAttrVoMapper;
	
	@Autowired
	private AttrallMapper attrallMapper;
	
	@Override
	public ZzguifanAttrVo findZzguifanAttrVoById(int id) {
		
		
		return zzguifanAttrVoMapper.findZzguifanAttrVoById(id);
	}

	@Override
	public List<AttrallListVo> findParentsByAttrall(List<Attrall> list) {
		
		List<AttrallListVo> tempList = new ArrayList<AttrallListVo>();
		for (Attrall attr : list) {
			AttrallListVo attrallListVo = new AttrallListVo();
			attrallListVo.setParents(new ArrayList<Attrall>());
			Attrall tempAttr = attr;
			while(tempAttr.getLevel()!=1){
				Attrall parentAttr = attrallMapper.findAttrallById(tempAttr.getParent_id());
				attrallListVo.getParents().add(0, parentAttr);
				tempAttr =parentAttr;
				
				
			}
			tempList.add(attrallListVo);
		}
		
		
		return tempList;
	}

	@Override
	public AttrallLevel getAttrallLevel() {
		AttrallLevel attrallLevel = new AttrallLevel();
		List<Attrall> allList = attrallMapper.findAllAttrall();
		attrallLevel.setAttr_name("root");
		attrallLevel.setCode("x");
		attrallLevel.setSub(new ArrayList<AttrallLevel>());
		for(Attrall attrall:allList){
			if(attrall.getLevel()==1)
			{
				AttrallLevel tempAttrallLevel = new AttrallLevel();
				tempAttrallLevel.setAttr_name(attrall.getAttr_name());
				tempAttrallLevel.setCode(attrall.getCode());
				tempAttrallLevel.setSub(new ArrayList<AttrallLevel>());
				attrallLevel.getSub().add(tempAttrallLevel);
			}
		}
		
		return null;
	}

	
}
