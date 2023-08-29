package org.sp.app0828.model.product;

import java.util.List;

public interface SubCategoryDAO {
	
	//CRUD
	public List selectAll(); //모든 값 가져오기
	public List selectAll(int topcategory_idx); //선택한 상위에 소속된 것만(topcategory_idx에 해당하는) 가져오기
}
