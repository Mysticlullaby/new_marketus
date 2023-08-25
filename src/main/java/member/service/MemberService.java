package member.service;

import member.dto.AuthInfo;
import member.dto.MemberDTO;

public interface MemberService {
	public AuthInfo signupProcess(MemberDTO dto);	
	public AuthInfo loginProcess(MemberDTO dto);	
	public MemberDTO editProcess(String member_id);
	public AuthInfo editProcess(MemberDTO memberDTO);
	public void deleteProcess(MemberDTO dto);
}
