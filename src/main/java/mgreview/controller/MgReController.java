package mgreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mgreview.DAO.MgReDAO;

@Controller
public class MgReController {
	private MgReDAO mgreDao;
	
	public MgReController() { 	}
	
@RequestMapping(value = "/MgReview.do") // 어떤 주소를 넣으면 컨트롤러가 작동되는지
	public String storeExecute() {
		return "MgReview"; // tiles에 정의된 definition의 이름
	}
	
	
}//end class
