package shop.service;

import java.util.List;

import member.dto.MemberDTO;
import shop.dto.CartDTO;
import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public interface ShopService {
	public List<ShopDTO> listProcess(ShopPageDTO sp);
	
	public int countProcess();
	
	public ShopDTO productProcess(int product_id);
	
	public void addCartProcess(CartDTO cartDTO, MemberDTO memberDTO);
}
