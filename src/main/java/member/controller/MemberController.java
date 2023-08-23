package member.controller;

import javax.servlet.http.HttpServletResponse;
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
	public ModelAndView login(MemberDTO memberDTO, HttpSession httpSession, HttpServletResponse httpresp) {
		ModelAndView mav = new ModelAndView();

		try {
			AuthInfo authinfo = memberService.loginProcess(memberDTO);
			httpSession.setAttribute("authInfo", authinfo); // httpSession에 로그인한 사용자의 정보를 저장
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
	
	// 회원정보 폼
	
	
//	// 회원정보 수정
//	@RequestMapping(value = "member/edit.do", method = RequestMethod.POST)
//	public String edit(MemberDTO memberDTO) {
//		memberService.editProcess(memberDTO);
//		return "redirect:/login.do";
//	}

} // end class
