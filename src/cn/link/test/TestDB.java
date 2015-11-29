package cn.link.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.text.AbstractDocument.LeafElement;

import org.junit.Before;
import org.junit.Test;

public class TestDB {

	Connection conn1;
	Connection conn2;
	Connection conn8;
	Statement stmt1;
	PreparedStatement stmt2;
	@Before
	public void init() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhengzhuang?user=root&password=123456");
		conn8 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kde_cm?user=root&password=123456");
		conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/union_kde_cm_data?characterEncoding=utf8&user=root&password=123456");
		stmt1 = conn1.createStatement();
	}
	//导入中国药典数据到全集表中
	@Test
	public void initYaodian() throws Exception{
		
		stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
		Statement stmt3=conn8.createStatement();
		ResultSet rs = stmt3.executeQuery("select attending from drug;");
		List<String> zzs = new ArrayList<String>();
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		while(rs.next()){
				String temp = rs.getString(1);
				
				
				if(temp!=null){
					temp = temp.trim();
					temp.replace("；", "，");
					if(!temp.equals("")){
						if(temp.contains("用于")){
							temp = temp.substring((temp.indexOf("用于")+"用于".length()),temp.length());
						}
						
						//System.out.println(temp);
						String[] temps = temp.split("，");
						
						for(String s :temps){
							System.out.println(s);
							map.put(s, 1);
							
						}
					    zzs.add(temp);
					}
					
				}
				
		}
		
		for(Entry<String, Integer> et :map.entrySet()){
			stmt2.setString(1, et.getKey());
			stmt2.setInt(2, 3);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	
	
	
//	@Test
//	public void initAllToGuifan() throws Exception{
//		Statement stmt3=conn2.createStatement();
//		ResultSet rs = stmt3.executeQuery("select id,zhengzhuang_name from zzall;");
//		stmt2 = conn2.prepareStatement("insert into zzall_zzguifan (zzall_id,zzguifan_id) values (?,?)");
//		
//		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
//		List<String> zs = new ArrayList<String>();
//		while(rs.next()){
//			   map1.put(rs.getString(2), rs.getInt(1));
//			    zs.add(rs.getString(2));
//		}
//		rs = stmt3.executeQuery("select id,zhengzhuang_name from zzguifan;");
//		while(rs.next()){
//			   map2.put(rs.getString(2), rs.getInt(1));
//		}
//		
//		
//		for(String s : zs){
//			
//			if(map2.containsKey(s)){
//				stmt2.setInt(1, map1.get(s));
//				stmt2.setInt(2, map2.get(s));
//				stmt2.executeUpdate();
//			}
//		}
//	}
	
//	class zznode{
//		String zz;
//		String code;
//		zznode parent;
//		int level;
//		List<zznode> childs;
//	}
	
	//导入四诊标准症状数据到全集表中
//		@Test
//	public void initSizhen() throws Exception{
//			ResultSet rs = stmt1.executeQuery("select zz,code from zhengz;");
//			List<zznode> nodes = new ArrayList<zznode>();
//			while(rs.next()){
//			    System.out.println("---------------------------");
//			    System.out.print(rs.getString(1)+"\t");
//			    System.out.print(rs.getString(2)+"\t");
//			    System.out.println();
//			    zznode node = new zznode();
//			    node.zz = rs.getString(1);
//			    node.code = rs.getString(2);
//			    nodes.add(node);
//			}
//			for(zznode node:nodes){
//				String temp = node.code.substring(0, node.code.length()-2);
//				for(zznode node2:nodes){
//					if(node2.code.equals(temp)){
//						node.parent = node2;
//						break;
//					}
//				}
//			}
//			zznode head = null;
//			for(zznode node:nodes){
//				if(node.parent==null)
//					head = node;
//				node.childs = new ArrayList<TestDB.zznode>();
//				for(zznode node2:nodes){
//					if(node2.parent!=null&&node2.parent==node)
//						node.childs.add(node2);
//						
//				}
//				
//			}
//			zznode now = head;
//			//print(now,1);
//			
//			Statement stmt3=conn2.createStatement();
//			stmt2 = conn2.prepareStatement("insert into zzguifan_attr (zzguifan_id,attr_id) values (?,?)");
//			rs = stmt3.executeQuery("select id,code from attrall;");
//			HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//			HashMap<Integer, String> map2 = new HashMap<Integer, String>();
//			
//			List<String> zzs = new ArrayList<String>();//code
//			
//			while(rs.next()){
//			    map1.put(rs.getString(2), rs.getInt(1));
//			    map2.put(rs.getInt(1),rs.getString(2));
//			    zzs.add(rs.getString(2));
//			}
//			
//			
//			
//			
//			rs = stmt3.executeQuery("select id,zhengzhuang_name from zzguifan;");
//			
//			
//			HashMap<String, Integer> map3 = new HashMap<String, Integer>();
//			HashMap<Integer, String> map4 = new HashMap<Integer, String>();
//			
//			
//			List<String> zzzs = new ArrayList<String>();//症状
//			
//			
//			
//			while(rs.next()){
//			    map3.put(rs.getString(2), rs.getInt(1));
//			    map4.put(rs.getInt(1),rs.getString(2));
//			    zzzs.add(rs.getString(2));
//			}
//			
//			for(String s : zzzs){
//				String codeparents = null;
//				for(zznode node:nodes){
//					if(node.zz.equals(s)){
//						if(node.parent!=null){
//							codeparents = node.parent.code;
//						}
//						break;
//					}
//				}
//				if(codeparents!=null){
//					stmt2.setInt(1, map3.get(s));
//					stmt2.setInt(2, map1.get(codeparents));
//					stmt2.executeUpdate();
//				}
//			}
//			
//			
//	}
//		
//		private void print(zznode now,int level) throws Exception {
//			if(now.childs.size()!=0){
//				System.out.println(now.zz+"----"+now.code);
//				stmt2 = conn2.prepareStatement("insert into attrall (attr_name,attr_dependency,code,level) values (?,?,?,?)");
//				stmt2.setString(1, now.zz);
//				stmt2.setString(2, "四诊");
//				stmt2.setString(3, now.code);
//				stmt2.setInt(4, level);
//				stmt2.executeUpdate();
//			}
//		
//			if(now.childs.size()!=0){
//				for(zznode temp:now.childs){
//					print(temp,level+1);
//				}
//			}
//		}
//		
		
		
		
		
		@Test
		public void testFunction(){
			System.out.println();
		}
}
