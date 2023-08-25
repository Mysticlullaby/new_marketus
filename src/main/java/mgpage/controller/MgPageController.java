package mgpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mgpage.dao.MgPageDAO;

@Controller
public class MgPageController {
	private MgPageDAO mgPageDAO;
	
	public MgPageController() {
	}
	
	public void setMgPageDao(MgPageDAO mgPageDAO) {
		this.mgPageDAO = mgPageDAO; 
	}
	
	@RequestMapping(value = "MgPage.do")
	public String MgpageExecute() {
		return "mgpage";
	}

}//end class
