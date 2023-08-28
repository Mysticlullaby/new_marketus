package payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//http://localhost:8090/marketus/payment/payment.do

@Controller
public class PaymentController {
	
	public PaymentController() {
	}
	
	// 결제창 화면
	@RequestMapping(value = "payment/payment.do", method = RequestMethod.GET)
	public String payment() {
		return "payment";
	}
}
