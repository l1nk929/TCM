package cn.link.tcm.po;

import java.util.List;

public class AttrallLevel {

	private String code;
	private String attr_name;
	private List<AttrallLevel> sub;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAttr_name() {
		return attr_name;
	}
	public void setAttr_name(String attr_name) {
		this.attr_name = attr_name;
	}
	public List<AttrallLevel> getSub() {
		return sub;
	}
	public void setSub(List<AttrallLevel> sub) {
		this.sub = sub;
	}
	
	public AttrallLevel() {
	}
}
