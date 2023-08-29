package pay.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class PayDaoImp implements PayDao {
	private SqlSessionTemplate sqlSession;

	public PayDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}// end class
