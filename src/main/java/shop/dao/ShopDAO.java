package shop.dao;

import java.util.List;

import member.dto.MemberDTO;
import shop.dto.CartDTO;
import shop.dto.OrderInfoDTO;
import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public interface ShopDAO {
	public List<ShopDTO> list(ShopPageDTO sp);
	
	public int count();

	public ShopDTO product(int product_id);
	
	public int orderCheck(MemberDTO memberDTO);
	
	public void newOrder(MemberDTO memberDTO);
	
	public OrderInfoDTO pickOrder(MemberDTO memberDTO);
	
	public void addCart(CartDTO cartDTO);
	
	public List<CartDTO> listCart(OrderInfoDTO orderInfoDTO);
	
	public void deleteCart(CartDTO cartDTO);
	
	public void editCart(CartDTO cartDTO);
	
	public CartDTO cartCheck(CartDTO cartDTO);
	
	public List<ShopDTO> search(String keyword);
	
	public int countResult(String keyword);
	
	public List<ShopDTO> category(String category);
	
	public int countCategory(String category);
	
	public void purchase(OrderInfoDTO orderInfoDTO);
	
	public void addSellCount(ShopDTO shopDTO);
	
	public List<Integer> getWeeklyHotId();
	
	public List<Integer> getMonthlyHotId();
}
