package mgpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mgpage.dao.MgPageDAO;

//http://localhost:8090/marketus/MgPage.do

@Controller
public class MgPageController {
	private MgPageDAO mgPageDAO;
	
	public MgPageController() {
	}
	
	//MgPageDAO의 객체를 가져와 mgpageDAO변수를 생성해 의존성을 주입(결합도를 낮춤)
	public void setMgPageDao(MgPageDAO mgPageDAO) {
		this.mgPageDAO = mgPageDAO; 
	}
	
	//주문확인 페이지 -http://localhost:8090/marketus/MgPage.do
	@RequestMapping(value = "MgPage.do")
	public String MgpageExecute() {
		return "mgpage";
	}
	
}//end class
