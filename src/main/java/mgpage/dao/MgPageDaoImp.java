package mgpage.dao;

import org.mybatis.spring.SqlSessionTemplate;

import mgpage.dto.MgPageDTO;

public class MgPageDaoImp implements MgPageDAO{
	private SqlSessionTemplate sqlSession;
	
	public MgPageDaoImp() { 	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String state(MgPageDTO dto) {
		return null;
	}

	@Override
	public MgPageDTO Order(int order_id) {
		return sqlSession.selectOne("mgpage.Order",order_id);
	}

	@Override
	public MgPageDTO member_id(String member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MgPageDTO product_id(String proguct_id) {
		// TODO Auto-generated method stub
		return null;
	}
}//end class
