package org.sp.app0828.admin.controller;

import java.util.List;

import org.sp.app0828.model.product.TopCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//관리자모드에서의 상품과 관련된 요청을 처리하는 하위 컨트롤러

//component-scan 태그의 검색대상 중 @Controller 이므로, 자동으로 메모리에 생성
@Controller
public class ProductController {
	
	//느슨하게 보유하자
	@Autowired
	private TopCategoryDAO topCategoryDAO;
	
	@RequestMapping(value="/admin/product/registform", method=RequestMethod.GET)
	public ModelAndView getForm() { 
		//3단계: 일시키기
		List topList = topCategoryDAO.selectAll();
		
		ModelAndView mav = new ModelAndView("admin/product/regist"); //페이지 명은 mav.setViewName 혹은 생성자에 넣어도 됨
		//4단계: 가져갈 것이 있다면 무조건 저장
		mav.addObject("topList", topList);
		
		return mav; //접두어, 접미어 떼고 view의 이름(클라이언트가 보게 될 결과값) 입력. '/' 생략
		
		//* ModelAndView에 저장할 데이터가 없을 경우에는 view의 이름만 넘겨주면 되므로, 이때는 String 형만 반환 가능
	}
}
