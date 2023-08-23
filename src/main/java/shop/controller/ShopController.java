package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.dto.ShopPageDTO;
import shop.service.ShopService;

// http://localhost:8090/marketus/shop.do

@Controller
public class ShopController {
	private ShopService shopService;
	private ShopPageDTO spdto;
	
	public ShopController() {
		
	}
	
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	@RequestMapping(value="/mainhome.do")
	public String homeExecute() {
		return "mainhome";
	}
	
	@RequestMapping(value="/shop.do")
	public ModelAndView listExecute(ModelAndView mav, @ModelAttribute("sp") ShopPageDTO sp) {
		int productCount = shopService.countProcess();
		if(productCount!=0) {
			if(sp.getCurrentPage()==0) {
				sp.setCurrentPage(1); 
			}
			this.spdto = new ShopPageDTO(sp.getCurrentPage(), productCount);
			mav.addObject("sp", this.spdto);
			mav.addObject("shopList", shopService.listProcess(spdto));
		}	
		mav.setViewName("shop");
		return mav;
	}
	

	@RequestMapping(value="/shop/product.do")
	public ModelAndView productExecute(int product_id, ModelAndView mav) {
		mav.addObject("shopDTO", shopService.productProcess(product_id));
		mav.setViewName("product");
		return mav;
	}
}
