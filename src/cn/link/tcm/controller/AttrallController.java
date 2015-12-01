package cn.link.tcm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.AttrallListVo;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallPageVo;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.ZzguifanAttrVo;
import cn.link.tcm.service.AttrService;
import cn.link.tcm.service.ZzallService;
import cn.link.tcm.service.ZzguifanService;


@Controller
public class AttrallController {

	@Autowired
	private AttrService attrService;
	
	@RequestMapping(value="/right")
	public String findZzall(int zzguifanid,Model model,HttpSession session){
		
		ZzguifanAttrVo zzguifanAttrVo = attrService.findZzguifanAttrVoById(zzguifanid);
		
		List<AttrallListVo> attrallVoList  = attrService.findParentsByAttrall(zzguifanAttrVo.getList());
		
		model.addAttribute("attrallVoList", attrallVoList);
		
		
		return "rightReal";
		
	}
}
