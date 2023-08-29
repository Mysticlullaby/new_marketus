package member.dao;

import member.dto.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO dto);
	public MemberDTO selectById(String member_id);
	public int memberidCheck(String member_id);
	public void updateMember(MemberDTO dto);
	public void deleteMember(MemberDTO dto);

}
