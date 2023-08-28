package org.sp.app0828.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

//mybatis의 설정 xml을 해석하여, SqlSessionFactory를 얻어온 후
//필요한 dao들에게 SqlSession을 제공해주기 위함

//설계분야에서의 분류가 아닌 경우 즉, 개발자가 정한 임의의 객체인 경우 그냥 컴포넌트라고 선언
public class MybatisConfig {
	private static MybatisConfig instance;
	SqlSessionFactory factory; //SqlSession을 여럿 가지고 있는 pool
	
	private MybatisConfig() {
		String resource = "org/sp/app0828/mybatis/config.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MybatisConfig getInstance() {
		if(instance==null) {
			instance = new MybatisConfig();
		}
		return instance;
	}
	
	//팩토리로부터 SqlSession을 제공해주는 메서드
	public SqlSession getSqlSession() {
		return factory.openSession();
	}
	
	//SqlSession을 닫는 메서드
	public void release(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	
}
