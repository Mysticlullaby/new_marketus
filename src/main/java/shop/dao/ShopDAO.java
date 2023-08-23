package shop.dao;

import java.util.List;

import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public interface ShopDAO {
	public List<ShopDTO> list(ShopPageDTO sp);
	
	public int count();

	public ShopDTO product(int product_id);
}
