package member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import member.dto.MemberDTO;

public class MemberDaoImp implements MemberDAO {
	private SqlSessionTemplate sqlSession;
	
	public MemberDaoImp() {
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override	
	public void insertMember(MemberDTO dto) {
		sqlSession.insert("member.insertMember", dto);
	} // MemberDTO에 담고있는 회원정보를 insertMember() 메서드로 넘기고, insertMember()는 회원정보를 member 테이블에 저장
	
	@Override
	public MemberDTO selectById(String member_id) {
		return sqlSession.selectOne("member.selectById", member_id);
	} // member_id(query_id)에 대한 select문을 실행한 후 한 개의 레코드를 지정한 타입으로 반환
	
	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.updateMember", dto);
	}
	
	@Override
	public void deleteMember(MemberDTO dto){
		sqlSession.delete("member.deleteMember", dto);
	}
	
}//end class
