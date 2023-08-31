package shop.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import member.dto.MemberDTO;
import shop.dto.CartDTO;
import shop.dto.OrderInfoDTO;
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

	@Override
	public int orderCheck(MemberDTO memberDTO) {
		return sqlSession.selectOne("shop.orderCheck", memberDTO);
	}

	@Override
	public void newOrder(MemberDTO memberDTO) {
		sqlSession.insert("shop.newOrder", memberDTO);
	}

	@Override
	public OrderInfoDTO pickOrder(MemberDTO memberDTO) {
		return sqlSession.selectOne("shop.pickOrder", memberDTO);
	}

	@Override
	public void addCart(CartDTO cartDTO) {
		sqlSession.insert("shop.addCart", cartDTO);		
	}

	@Override
	public List<CartDTO> listCart(OrderInfoDTO orderInfoDTO) {
		return sqlSession.selectList("shop.listCart", orderInfoDTO);
	}

	@Override
	public void deleteCart(CartDTO cartDTO) {
		sqlSession.delete("shop.deleteCart", cartDTO);		
	}

	@Override
	public void editCart(CartDTO cartDTO) {
		sqlSession.update("shop.editCart", cartDTO);		
	}

	@Override
	public CartDTO cartCheck(CartDTO cartDTO) {
		return sqlSession.selectOne("shop.cartCheck", cartDTO);
	}

	@Override
	public List<ShopDTO> search(String keyword) {
		return sqlSession.selectList("shop.search", keyword);
	}

	@Override
	public int countResult(String keyword) {
		return sqlSession.selectOne("shop.countResult", keyword);
	}

	@Override
	public List<ShopDTO> category(String category) {
		return sqlSession.selectList("shop.category", category);
	}

	@Override
	public int countCategory(String category) {
		return sqlSession.selectOne("shop.countCategory", category);
	}

	@Override
	public void purchase(OrderInfoDTO orderInfoDTO) {
		sqlSession.update("shop.purchase", orderInfoDTO);
		
	}

	@Override
	public void addSellCount(ShopDTO shopDTO) {
		sqlSession.update("shop.addSellCount", shopDTO);
	}

	@Override
	public List<Integer> getWeeklyHotId() {
		return sqlSession.selectList("shop.getWeeklyHotId", sqlSession);
	}

}
