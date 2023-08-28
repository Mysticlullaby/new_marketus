package mgpage.dao;

import org.mybatis.spring.SqlSessionTemplate;

import mgpage.dto.MgPageDTO;

public class MgPageDAOImp implements MgPageDAO{
	private SqlSessionTemplate sqlSession;
	public MgPageDAOImp() { 	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	@Override
	public int Status(MgPageDTO dto) {
		return sqlSession.selectOne("ORDER_INFO.Status",dto);}

	@Override
	public MgPageDTO Order(int Order_id) {
		return sqlSession.selectOne("ORDER_INFO.Order", Order_id);

	}

	@Override
	public MgPageDTO Member_id(String Member_id) {
		return sqlSession.selectOne("ORDER_INFO.member_id",Member_id);

	}

	@Override
	public MgPageDTO Product_id(String Product_id) {
		return sqlSession.selectOne("ORDER_INFO.Product_id",Product_id);

	}

	@Override
	public String InOrder(MgPageDTO dto) {
		return sqlSession.selectOne("ORDER_INFO.InOrder",dto);

	}

	@Override
	public String InProgress(MgPageDTO dto) {
		return sqlSession.selectOne("ORDER_INFO.InProgress",dto);

	}

	@Override
	public String History(MgPageDTO dto) {
		return sqlSession.selectOne("ORDER_INFO.History",dto);
	}


}//end class
