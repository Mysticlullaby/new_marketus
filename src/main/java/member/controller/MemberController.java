package member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import member.dto.AuthInfo;
import member.dto.MemberDTO;
import member.exception.WrongPasswordException;
import member.service.MemberService;
import shop.service.ShopService;

// http://localhost:8090/marketus/member/login.do
// http://localhost:8090/marketus/member/signup.do

@Controller
public class MemberController {
	private MemberService memberService;
	private ShopService shopService;

	public MemberController() {
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	// 회원가입 폼
	@RequestMapping(value = "member/signup.do", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	// 회원가입 처리
	@RequestMapping(value = "member/signup.do", method = RequestMethod.POST)
	public String signup(MemberDTO dto) {
		memberService.signupProcess(dto);
		return "redirect:/member/login.do";
	}
	
	// 회원가입 중복체크
	@RequestMapping(value="member/idCheck.do")
	public @ResponseBody int memberidCheck(String member_id) {
		int result = memberService.memberidCheck(member_id);
		return result;
	}

	// 로그인 화면
	@RequestMapping(value = "member/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 로그인 처리
	@RequestMapping(value = "member/login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberDTO memberDTO, HttpSession httpSession, HttpServletResponse httpresp) {// httpSession에 로그인한 사용자의 정보를 저장
		ModelAndView mav = new ModelAndView();
		Cookie rememberCookie = new Cookie("SAVE", memberDTO.getMember_id());
		rememberCookie.setPath("/");
		
		try {
			AuthInfo authInfo = memberService.loginProcess(memberDTO);
			httpSession.setAttribute("authInfo", authInfo);
			
			if(memberDTO.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60);
			} else {
				rememberCookie.setMaxAge(0);
			}
			
			httpresp.addCookie(rememberCookie);
			mav.setViewName("redirect:/mainhome.do");
		} catch (WrongPasswordException e) {
			mav.addObject("errorMessage", e.getMessage());
			mav.setViewName("login");
		}
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "member/logout.do")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate(); // 세션 무효화 처리
		return "redirect:/mainhome.do";
	}
	
	// 회원정보수정 폼
	@RequestMapping(value = "member/edit.do", method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mav, HttpSession httpSession) { // ModelAndView 값이 있으면, return이나 값 전달을 위해 model을 사용할 필요없음
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo"); // 세션의 값을 authInfo라고 이름정하고, httpSession에서 "authInfo"라는 이름으로 저장된 속성의 값을 가져옴		
		mav.addObject("memberDTO", memberService.editProcess(authInfo.getMember_id()));
		mav.setViewName("edit");
		return mav;
	} // "authInfo"는 유저의 로그인 정보를 나타내는 객체이며, 로그인 성공 후 세션에 저장됨
	
	// 회원정보수정 처리
	@RequestMapping(value = "member/edit.do", method = RequestMethod.POST)
	public String edit(MemberDTO memberDTO, HttpSession httpSession) { // httpSession에 로그인한 사용자의 정보를 저장하기 위해 매개변수명 정의
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo"); 
		memberDTO.setMember_id(authInfo.getMember_id()); // memberDTO 객체에 현재 로그인한 사용자의 id를 설정
		authInfo = memberService.editProcess(memberDTO); // service 객체에 edit메서드를 호출하여 memberDTO를 기반으로 회원정보 수정 및 수정값 반환
		httpSession.setAttribute("authInfo", authInfo); // httpSession 객체에 "authInfo"라는 이름으로 인증정보(authInfo 객체)를 저장
		return "redirect:/mainhome.do";
	}

	// 회원탈퇴 폼
	@RequestMapping(value = "member/delete.do", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}
	
	// 회원탈퇴 처리
	@RequestMapping(value = "member/delete.do", method = RequestMethod.POST)
	public String delete(MemberDTO memberDTO, AuthInfo authInfo, HttpSession httpSession, RedirectAttributes rttr) {	
		
		AuthInfo member = (AuthInfo) httpSession.getAttribute("authInfo"); // 세션에서 가져온 authInfo 데이터를 "member"라는 변수에 저장
		String sessionPass = member.getPassword(); // member에서 패스워드를 가져와서 sessionPass 변수에 저장
		String memberpass = memberDTO.getPassword(); // user가 입력한 패스워드를 memberDTO에서 가져와서 memberpass 변수에 저장
		
		if(!(sessionPass.equals(memberpass))) {
			rttr.addFlashAttribute("msg", false); // url에 노출되지 않고 redirect 시 데이터 전달, 받을 때 사용
			return "redirect:/member/delete.do";
		}
		memberService.deleteProcess(memberDTO);
		httpSession.invalidate();
		return "redirect:/mainhome.do"; // 해당 경로로 돌아가 로그아웃 상태로 전환
	}
	
	@RequestMapping(value="member/cart.do")
	public ModelAndView cart(ModelAndView mav ,HttpSession httpSession) {
		//세션에서 authInfo 정보를 불러옵니다.
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		//불러온 authInfo에 해당하는 멤버의 DTO를 가져옵니다.
		MemberDTO memberDTO = memberService.editProcess(authInfo.getMember_id());
		mav.addObject("orderInfo", shopService.getOrderProcess(memberDTO));
		mav.setViewName("cart");
		return mav;
	}

} // end class
