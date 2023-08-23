package member.dao;

import member.dto.MemberDTO;

public interface MemberDAO {
	public int insertMember(MemberDTO dto);
	public MemberDTO selectById(String member_id);
	public void updateMember(MemberDTO dto);
	public void updateByPass(MemberDTO dto);	
	
}//end interface
