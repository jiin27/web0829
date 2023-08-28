package org.sp.app0828.model.admin;

import org.apache.ibatis.session.SqlSession;
import org.sp.app0828.domain.Admin;
import org.sp.app0828.mybatis.MybatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//이 클래스는 AdminDAO 형 中 하나이다.
//component-scan에 의해 DAO의 인스턴스를 생성해준다(스프링이)
@Repository
public class MybatisAdminDAO implements AdminDAO{
	
	@Autowired
	private MybatisConfig mybatisConfig;
	
	public Admin login(Admin admin) {
		SqlSession sqlSession = mybatisConfig.getSqlSession();
		return sqlSession.selectOne("Admin.login", admin);
	}

	public void insert(Admin admin) {
		
	}
	
}
