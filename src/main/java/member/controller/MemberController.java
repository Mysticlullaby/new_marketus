package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.dto.AuthInfo;
import member.dto.MemberDTO;
import member.exception.WrongPasswordException;
import member.service.MemberService;

// http://localhost:8090/marketus/member/login.do
// http://localhost:8090/marketus/member/signup.do

@Controller
public class MemberController {
	private MemberService memberService;

	public MemberController() {
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	// 회원가입 폼
	@RequestMapping(value = "member/signup.do", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}

	// 회원가입 처리
	@RequestMapping(value = "member/signup.do", method = RequestMethod.POST)
	public String singup(MemberDTO dto) {
		memberService.signupProcess(dto);
		return "redirect:/member/login.do";
	}

	// 로그인 화면
	@RequestMapping(value = "member/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 로그인 처리
	@RequestMapping(value = "member/login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberDTO memberDTO, HttpSession httpSession) {// httpSession에 로그인한 사용자의 정보를 저장
		ModelAndView mav = new ModelAndView();

		try {
			AuthInfo authInfo = memberService.loginProcess(memberDTO);
			httpSession.setAttribute("authInfo", authInfo); 
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
	public String edit(MemberDTO memberDTO, HttpSession httpSession) { // httpSession에 로그인한 사용자의 정보를 저장하기 떄문에 호출필요
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		memberDTO.setMember_id(authInfo.getMember_id()); // 회원정보 수정을 위해 입력된 memberDTO 객체에 현재 로그인한 사용자의 ID를 설정하는 역할
		authInfo = memberService.editProcess(memberDTO); // service 객체에 edit 메서드를 호출하여 memberDTO를 기반으로 회원정보 수정 및 수정값 반환
		httpSession.setAttribute("authInfo", authInfo);
		return "redirect:/mainhome.do";
	}
//	
//	// 회원탈퇴
//	@RequestMapping(value = "member/edit.do", method = RequestMethod.GET)
//	public String delete(MemberDTO memberDTO, HttpSession httpSession) {
//		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
//		
//		return null;		
//	}

} // end class
