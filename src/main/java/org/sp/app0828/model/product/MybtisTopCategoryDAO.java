package org.sp.app0828.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.app0828.domain.TopCategory;
import org.sp.app0828.mybatis.MybatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//TopCategoryDAO 의 자식 중, mybatis를 이용한 DAO를 정의
@Repository
public class MybtisTopCategoryDAO implements TopCategoryDAO{

	//SqlSession을 얻을 수 있는 MybatisConfig 객체 보유
	@Autowired
	private MybatisConfig mybatisConfig;
	
	public void insert(TopCategory topCategory) {
		
	}

	public List selectAll() {
		SqlSession sqlSession = mybatisConfig.getSqlSession();
		List list = sqlSession.selectList("TopCategory.selectAll");
		mybatisConfig.release(sqlSession);
		
		return list;
	}

	public TopCategory select(int topcategory_idx) {
		return null;
	}

	public void update(TopCategory topCategory) {
		
	}

	public void delete(int topcategory_idx) {
		
	}

}
