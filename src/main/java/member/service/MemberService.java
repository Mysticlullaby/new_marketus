package member.service;

import member.dto.AuthInfo;
import member.dto.MemberDTO;

public interface MemberService {
//	public AuthInfo signupProcess(MemberDTO dto);
	public void signupProcess(MemberDTO dto);
	public AuthInfo loginProcess(MemberDTO dto);
//	public void editProcess(MemberDTO dto);
	
	

}
