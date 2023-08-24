package member.service;

import member.dto.AuthInfo;
import member.dto.MemberDTO;

public interface MemberService {
	public AuthInfo signupProcess(MemberDTO dto);	
	public AuthInfo loginProcess(MemberDTO dto);	
	public MemberDTO editProcess(String member_id);
	public AuthInfo editProcess(MemberDTO memberDTO);	
} // 회원가입, 로그인, 회원정보 수정하려는 회원정보를 가져오는 단계

//	member_id를 받아와서 해당 아이디를 가진 회원의 정보를 데이터베이스에서 조회
//	조회된 회원 정보를 MemberDTO 형태로 반환
//	이렇게 반환된 MemberDTO 객체에는 해당 회원의 정보가 담겨 있음
//	이후에 회원 정보를 수정하는 작업은 다른 메서드나 컨트롤러 등에서 이루어짐
//	editProcess 메서드는 수정하려는 회원 정보를 가져오기 위한 단계를 수행
//	하지만 그 자체로는 실제 회원 정보를 수정하는 로직을 포함하지 않음
//	해당 메서드의 반환 값인 MemberDTO 객체는 수정하려는 회원 정보를 담고 있음
//	이 정보를 기반으로 실제로 데이터베이스에서 회원 정보를 수정하는 작업이 이루어짐