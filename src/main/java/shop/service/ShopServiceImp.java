package shop.service;

import java.util.List;

import shop.dao.ShopDAO;
import shop.dto.ShopDTO;
import shop.dto.ShopPageDTO;

public class ShopServiceImp implements ShopService{
	private ShopDAO shopDao;

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}
	
	@Override
	public List<ShopDTO> listProcess(ShopPageDTO sp) {
		return shopDao.list(sp);
	}

	@Override
	public int countProcess() {
		return shopDao.count();
	}

	@Override
	public ShopDTO productProcess(int product_id) {
		return shopDao.product(product_id);
	}

}
