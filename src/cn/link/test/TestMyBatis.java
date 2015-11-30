package cn.link.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.link.tcm.po.Zzall;

public class TestMyBatis {

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
