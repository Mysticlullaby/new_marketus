package shop.service;

import java.util.List;

import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public interface ShopService {
	public List<ShopDTO> listProcess(ShopPageDTO sp);
	
	public int countProcess();
	
	public ShopDTO productProcess(int product_id);
}
