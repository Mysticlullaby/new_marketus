package pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8090/marketus/pay/payment.do
//https://develoyummer.tistory.com/94

@Controller
public class PayController {
	
	public PayController() {
	}

	@RequestMapping(value = "pay/pay.do")
	public String payExecute() {
		return "payt";
	}
	
	@RequestMapping(value = "pay/payment.do")
	public String payment() {
		return "payment";
	}
	
	@RequestMapping(value = "pay/paymentRes.do", method = RequestMethod.GET)
	public String paymentRes() {
		return "paymentRes";
	}
	
}// end class
