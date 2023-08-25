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
	
//	public void signupProcess(MemberDTO dto) {
//		memberDao.insertMember(dto);
//	} // 회원가입 및 db 입력용 메서드
	
	@Override
	public AuthInfo signupProcess(MemberDTO dto) { // 회원 가입 후에 해당 회원의 인증 정보를 생성하고 세션에 저장하기 위함
		memberDao.insertMember(dto);
		return new AuthInfo(dto.getMember_id(), dto.getMember_name(), dto.getPassword());		
	} // 로그인 성공 후 인증상태 정보를 보관할 때 사용할 메서드

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
	} // 로그인 창에서 에러 메세지를 띄워줄 메서드

	@Override
	public MemberDTO editProcess(String member_id) {
		return memberDao.selectById(member_id); // 해당 멤버의 ID를 조회하고 반환
	} // member_Id를 기반으로 회원 정보를 조회하고 반환하는 역할(수정 전 정보를 조회)
	
	@Override
	public AuthInfo editProcess(MemberDTO dto) {
		memberDao.updateMember(dto);
		MemberDTO member = memberDao.selectById(dto.getMember_id()); // member_id를 기반으로 DB에서 회원정보 조회
		return new AuthInfo(member.getMember_id(), member.getMember_name(), member.getPassword()); // 수정된 회원정보로 생성된 authinfo 객체 반환
	} // 회원정보를 수정하고 업데이트된 정보를 사용하여 인증정보 객체를 생성하는 역할(수정 후의 정보를 업데이트)
	
//	public AuthInfo deleteProcess(MemberDTO dto) {
//		
//		return null;
//	}

}//end class
