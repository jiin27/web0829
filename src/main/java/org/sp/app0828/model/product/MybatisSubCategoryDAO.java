package org.sp.app0828.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.app0828.mybatis.MybatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisSubCategoryDAO implements SubCategoryDAO{
	
	@Autowired
	private MybatisConfig mybatisConfig; //왜 보유해야 하는지. 어떤 관계가 있는지.
	
	public List selectAll() {
		
		return null;
	}

	public List selectAll(int topcategory_idx) {
		SqlSession sqlSession=mybatisConfig.getSqlSession();
		List list=sqlSession.selectList("SubCategory.selectAllByFkey", topcategory_idx);
		mybatisConfig.release(sqlSession); //반납
		
		return list;
	}

}
