package pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pay.dao.PayDao;

@Controller
public class PayController {
	private PayDao payDao;
	
	public PayController() { }
	
	@RequestMapping(value="/pay.do")
	public String payExecute() {
		return "pay";
	}

}//end class
