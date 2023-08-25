package shop.service;

import java.util.List;

import member.dto.MemberDTO;
import shop.dao.ShopDAO;
import shop.dto.CartDTO;
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

	@Override
	public void addCartProcess(CartDTO cartDTO, MemberDTO memberDTO) {
		int orderCheck = shopDao.orderCheck(memberDTO);
		
		//해당 member의 order가 없으면 order를 새로 생성합니다.
		if(orderCheck==0) {
			shopDao.newOrder(memberDTO);
			orderCheck++;
		}
		
		//해당 member의 order를 불러와서 cart 데이터가 어느 order에 귀속될 것인지 지정해줍니다.
		if(orderCheck==1) {
			int orderID = shopDao.pickOrder(memberDTO).getOrder_id();
			cartDTO.setOrder_id(orderID);
			shopDao.addCart(cartDTO);
		}
	}

}
