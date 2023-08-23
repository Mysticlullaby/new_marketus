package member.service;

import member.dao.MemberDAO;
import member.dto.AuthInfo;
import member.dto.MemberDTO;
import member.exception.WrongPasswordException;

public class MemberServiceImp implements MemberService {
	private MemberDAO memberDao;
	
	public MemberServiceImp() {
	}
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public void signupProcess(MemberDTO dto) {
		memberDao.insertMember(dto);
	}// 회원가입 및 db 입력용 클래스
	
//	@Override
//	public AuthInfo signupProcess(MemberDTO dto) {
//		memberDao.insertMember(dto); //dto를 받아서 insertMember를 호출하면서 memberdao로 전송
//		return new AuthInfo(dto.getMember_id(), dto.getMember_name(), dto.getPassword());
//	}// 로그인 성공 후 인증상태 정보를 보관할 때 사용할 클래스
	
	@Override
	public AuthInfo loginProcess(MemberDTO dto) {
		MemberDTO member = memberDao.selectById(dto.getMember_id());
		if (member == null) {
			throw new WrongPasswordException("회원가입이 필요합니다");
		}
		if (!member.matchPassword(dto.getPassword())) {
			throw new WrongPasswordException("비밀번호를 확인해주세요");
		}
		return new AuthInfo(member.getMember_id(), member.getMember_name(), member.getPassword());
	}// 로그인 창에서 에러 메세지를 띄워줄 클래스

}//end class
