package cn.link.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.link.tcm.mapper.AttrallMapper;
import cn.link.tcm.mapper.ZzallMapper;
import cn.link.tcm.mapper.ZzguifanMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.Zzguifan;

public class TestMyBatis {
	
	private ApplicationContext applicationContext;
	@Before
	public void setupInit(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}

	
	@Test
	public void testZzall() throws Exception{
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		Zzall zz = zzallMapper.findZzallById(302);
		System.out.println(zz);
		
	}
	
	@Test
	public void testZzGUifan() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = zzallMapper.findZzguifanById(5);
		System.out.println(zz);
		
	}
	
	@Test
	public void testZzGUifan2() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		List<Zzguifan> zzs = zzallMapper.findAllZzguifan();
		System.out.println(zzs.size());
		
	}
	
	@Test
	public void testZzGUifan3() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = new Zzguifan();
		zz.setZhengzhuang_name("≤‚ ‘");
		
		zzallMapper.addZzguifan(zz);
		
		System.out.println(zz.getId());
		
		zz.setZhengzhuang_name("≤‚ ‘2");
		zzallMapper.updateZzguifanZhengzhuangName(zz);
		
		zz = zzallMapper.findZzguifanById(zz.getId());
		
		System.out.println(zz);
		
		zzallMapper.deleteZzguifanById(zz.getId());
		
		zz = zzallMapper.findZzguifanById(zz.getId());
		
		System.out.println(zz);
	}
	
	@Test
	public void testAttr(){
		AttrallMapper attrallMapper = (AttrallMapper) applicationContext.getBean("attrallMapper");
		Attrall attrall = attrallMapper.findAttrallById(385);
		System.out.println(attrall);
		
		List<Attrall> list = attrallMapper.findAttrsByParentId(attrall.getId());
		for(Attrall attr:list){
			System.out.println(attr);
		}
		
		Attrall newattr = new Attrall();
		newattr.setAttr_dependency("»Àπ§");
		newattr.setAttr_name("≤‚ ‘’‰");
		newattr.setCode("0106");
		newattr.setLevel(attrall.getLevel()+1);
		newattr.setParent_id(attrall.getId());
		
		attrallMapper.addAttrall(newattr);
		
		list = attrallMapper.findAttrsByParentId(attrall.getId());
		for(Attrall attr:list){
			System.out.println(attr);
		}
	}
	
	
	
	@Test
	public void testTest() throws Exception{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = factory.openSession();
		
		Zzall zz = sqlSession.selectOne("test.findZzallById",310);
		
		System.out.println(zz);
		
		
	}
}
