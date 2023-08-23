package shop.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public class ShopDaoImp implements ShopDAO{
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ShopDTO> list(ShopPageDTO sp) {
		return sqlSession.selectList("shop.list", sp);
	}

	@Override
	public int count() {
		return sqlSession.selectOne("shop.count");
	}

	@Override
	public ShopDTO product(int product_id) {
		return sqlSession.selectOne("shop.product", product_id);
	}

}
