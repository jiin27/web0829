package org.sp.app0828.admin.controller;

import java.util.List;

import org.sp.app0828.model.product.SubCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

//SubCategory와 관련된 요청을 전담하는 하위 컨트롤러
@Controller
public class SubCategoryController {
	@Autowired
	private SubCategoryDAO subCategoryDAO; //결합도를 약하게 보유한다는 건 부모 클래스를 보유한다는 것!!!
	
	//상위 카테고리에 소속된 하위 목록 가져오기
	@RequestMapping(value="/admin/subcategory/list", produces="application/json;charset=utf-8", method=RequestMethod.GET)
	@ResponseBody
	public String getListByTopIdx(int topcategory_idx) {
		//3단계: 일시키기
		List subList=subCategoryDAO.selectAll(topcategory_idx);
		Gson gson = new Gson();
		
		String json = gson.toJson(subList);
		
		//4단계: ModelAndView 에 저장해 넘기는 것은 완전한 jsp 파일을 넘기는 것 -> 새로고침 됨 -> 4단계 진행 X
		
		return json;
	}
}
