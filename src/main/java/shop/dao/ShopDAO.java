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
}
