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
import cn.link.tcm.mapper.ZzallZzguifanVoMapper;
import cn.link.tcm.mapper.ZzguifanAttrVoMapper;
import cn.link.tcm.mapper.ZzguifanMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.po.ZzguifanAttrVo;

public class TestMyBatis {
	
	private ApplicationContext applicationContext;
	@Before
	public void setupInit(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}
	@Test
	public void testService() throws Exception{
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		Zzall zz = zzallMapper.findZzallById(302);
		System.out.println(zz);
		
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
		zz.setZhengzhuang_name("≤‚ ‘πÊ∑∂3");
		
		zzallMapper.addZzguifan(zz);
		
		System.out.println(zz.getId());
//		
//		zz.setZhengzhuang_name("≤‚ ‘2");
//		zzallMapper.updateZzguifanZhengzhuangName(zz);
//		
//		zz = zzallMapper.findZzguifanById(zz.getId());
//		
//		System.out.println(zz);
//		
//		zzallMapper.deleteZzguifanById(zz.getId());
//		
//		zz = zzallMapper.findZzguifanById(zz.getId());
//		
//		System.out.println(zz);
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
		newattr.setAttr_name("≤‚ ‘’‰2");
		newattr.setCode("0107");
		newattr.setLevel(attrall.getLevel()+1);
		newattr.setParent_id(attrall.getId());
		
		attrallMapper.addAttrall(newattr);
		System.out.println(newattr);
		
//		list = attrallMapper.findAttrsByParentId(attrall.getId());
//		for(Attrall attr:list){
//			System.out.println(attr);
//		}
	}
	
	@Test
	public void testZzallZzguifanVo(){
		ZzallZzguifanVoMapper zzVoMapper = (ZzallZzguifanVoMapper) applicationContext.getBean("zzallZzguifanVoMapper");
		ZzallZzguifanVo zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
//		System.out.println(zzVo);
//		
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = zzallMapper.findZzguifanById(307);
//		zzVo.getList().add(zz);
//		
//		zz = zzallMapper.findZzguifanById(306);
//		zzVo.getList().add(zz);
//		
//		zzVoMapper.addZzallZzguifanVo(zzVo);
//		
//		zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
		
		System.out.println(zzVo);
		
		List<Zzguifan> list = zzVo.getList();
		Zzguifan dzz = null;
		for(Zzguifan zzzz:list){
			if(zzzz.getZhengzhuang_name().equals("≤‚ ‘πÊ∑∂2"))
				dzz = zzzz;
		}
		list.remove(dzz);
		list.add(zz);
		
		zzVoMapper.deleteZzallZzguifanVo(zzVo);
		zzVoMapper.addZzallZzguifanVo(zzVo);
		
		zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
		
		System.out.println(zzVo);
		
	}
	
	@Test
	public void testZzguifanAttrVo(){
		ZzguifanAttrVoMapper zzMapper = (ZzguifanAttrVoMapper) applicationContext.getBean("zzguifanAttrVoMapper");
		ZzguifanMapper zzguifanMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		AttrallMapper attrallMapper = (AttrallMapper) applicationContext.getBean("attrallMapper");
		
		ZzguifanAttrVo zz = zzMapper.findZzguifanAttrVoById(305);
		
		Attrall a1 = attrallMapper.findAttrallById(459);
		Attrall a2 = attrallMapper.findAttrallById(460);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(zz);
		
		zz.getList().add(a1);
		zzMapper.addZzguifanAttrVo(zz);
		
		zz = zzMapper.findZzguifanAttrVoById(305);
		System.out.println(zz);
		
		zz.getList().remove(0);
		
		zzMapper.deleteZzguifanAttrVo(zz);
		zz = zzMapper.findZzguifanAttrVoById(305);
		System.out.println(zz);
		
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
