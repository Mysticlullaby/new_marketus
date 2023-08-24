package member.dao;

import member.dto.MemberDTO;

public interface MemberDAO {
	public int insertMember(MemberDTO dto);	
	public MemberDTO selectById(String member_id);	
	public void updateMember(MemberDTO dto);
	public void deleteMember(MemberDTO dto);
}

// dto: MemberDTO 객체는 업데이트할 회원 정보를 담고 있으며, 이 객체의 정보를 기반으로 데이터베이스 내의 해당 회원의 정보를 수정
// updateMember 메서드는 DAO 역할을 하며, 데이터베이스와 상호작용하여 회원 정보를 수정
// 이러한 DAO 메서드는 서비스(Service) 계층에서 호출되어 실제로 비즈니스 로직을 수행하는데 사용