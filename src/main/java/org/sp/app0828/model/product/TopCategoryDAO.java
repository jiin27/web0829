package org.sp.app0828.model.product;

import java.util.List;

import org.sp.app0828.domain.TopCategory;

//TopCategoryDAO 들의 최상위 객체(인터페이스로 결합도가 낮아 mybatis, hibernate 등 여러 툴을 변환 가능)
public interface TopCategoryDAO {
	
	//CRUD 어떤 툴을 쓰더라도 최상위 DAO 객체가 무조건 가지고 있어야 할 메서드
	public void insert(TopCategory topCategory); //등록
	public List selectAll(); //모든 것 가져오기
	public TopCategory select(int topcategory_idx); //한 건 가져오기
	public void update(TopCategory topCategory); //한 건 수정
	public void delete(int topcategory_idx); //한 건 삭제
}
