package shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.dto.AuthInfo;
import member.dto.MemberDTO;
import member.service.MemberService;
import shop.dto.CartDTO;
import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;
import shop.service.ShopService;

// http://localhost:8090/marketus/mainhome.do

@Controller
public class ShopController {
	private ShopService shopService;
	private MemberService memberService;
	private ShopPageDTO spdto;
	
	public ShopController() {
		
	}
	
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/mainhome.do")
	public ModelAndView homeExecute(ModelAndView mav) {
		List<ShopDTO> shopList = shopService.getWeeklyHotProcess();
		for(ShopDTO product: shopList) {
			System.out.println("(controller)" + product.getProduct_name());
		}
		mav.addObject("shopList", shopList);
		return mav;
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
	
	@ResponseBody
	@RequestMapping(value="/shop/addCart.do", produces = "application/text; charset=UTF-8")
	public String addCartExecute(CartDTO cartDTO, HttpSession httpSession, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		return shopService.addCartProcess(cartDTO, memberDTO);
	}
	
	@ResponseBody
	@RequestMapping(value="/member/deleteCart.do")
	public List<CartDTO> deleteCartExecute(CartDTO cartDTO, HttpSession httpSession) {
		shopService.deleteCartProcess(cartDTO);
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		return shopService.listCartProcess(memberDTO);
	}
	
	@ResponseBody
	@RequestMapping(value="/member/editCart.do")
	public List<CartDTO> editCartExecute(CartDTO cartDTO, HttpSession httpSession){
		shopService.editCartProcess(cartDTO);
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		return shopService.listCartProcess(memberDTO);
	}
	
	@ResponseBody
	@RequestMapping(value="/member/getCart.do")
	public List<CartDTO> getCartExecute(HttpSession httpSession){
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		return shopService.listCartProcess(memberDTO);
	}
	
	@RequestMapping(value="/search.do")
	public ModelAndView searchExecute(String keyword, ModelAndView mav,@ModelAttribute("sp") ShopPageDTO sp) {
		int resultCount = shopService.countResultProcess(keyword);
		if(resultCount!=0) {
			if(sp.getCurrentPage()==0) {
				sp.setCurrentPage(1); 
			}
			this.spdto = new ShopPageDTO(sp.getCurrentPage(), resultCount);
			mav.addObject("sp", this.spdto);
			mav.addObject("shopList", shopService.searchProcess(keyword));
		}
		mav.setViewName("shop");
		return mav;
	}
	
	@RequestMapping(value="/category.do")
	public ModelAndView categoryExecute(String category, ModelAndView mav, @ModelAttribute("sp") ShopPageDTO sp) {
		System.out.println(category);
		int resultCount = shopService.countCategoryProcess(category);
		System.out.println(resultCount);
		if(resultCount!=0) {
			if(sp.getCurrentPage()==0) {
				sp.setCurrentPage(1); 
			}
			this.spdto = new ShopPageDTO(sp.getCurrentPage(), resultCount);
			mav.addObject("sp", this.spdto);
			mav.addObject("shopList", shopService.categoryProcess(category));
		}
		mav.setViewName("shop");
		return mav;
	}
	
	@RequestMapping(value="/member/purchase.do")
	public void purchaseExecute(HttpSession httpSession) {
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		shopService.purchaseProcess(memberDTO);
		System.out.println("authInfo : " + authInfo.getMember_id());
	}
	
}
