package mgreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mgreview.DAO.MgReDAO;
import store.dao.StoreDao;



@Controller
public class MgReController {
	private MgReDAO mgreDao;
	
	public MgReController() { 	}
	
	public void setMgReview(MgReDAO mgreDao) {
		this.mgreDao = mgreDao;
	}
	
@RequestMapping(value = "mgreview.do") // 어떤 주소를 넣으면 컨트롤러가 작동되는지
	public String storeExecute() {
		return "mgreview"; // tiles에 정의된 definition의 이름
	}
	
	
}//end class
