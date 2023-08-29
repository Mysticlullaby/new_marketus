package shop.service;

import java.util.List;

import member.dto.MemberDTO;
import shop.dao.ShopDAO;
import shop.dto.CartDTO;
import shop.dto.OrderInfoDTO;
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
	public String addCartProcess(CartDTO cartDTO, MemberDTO memberDTO) {
		int orderCheck = shopDao.orderCheck(memberDTO);
		
		//해당 member의 order가 없으면 order를 새로 생성합니다.
		if(orderCheck==0) {
			shopDao.newOrder(memberDTO);
			orderCheck++;
		}
				
		if(orderCheck==1) {
			int orderID = shopDao.pickOrder(memberDTO).getOrder_id();
			cartDTO.setOrder_id(orderID);
			CartDTO db_cartDTO = shopDao.cartCheck(cartDTO);
			try {
				//이미 장바구니에 동일 상품이 있는 경우
				int cl_product_count = cartDTO.getProduct_count();
				int chk_product_count = db_cartDTO.getProduct_count();
				cartDTO.setProduct_count(cl_product_count+chk_product_count);
				shopDao.editCart(cartDTO);
				return "상품이 장바구니에 이미 있습니다. 수량을 추가합니다.";
				
			}catch(NullPointerException ex) {
				//장바구니에 동일 상품이 없는 경우
				shopDao.addCart(cartDTO);
				return "상품이 장바구니에 추가되었습니다.";
			}
			/*
			 * if(cartCheck != null) { //이미 장바구니에 동일 상품이 있는 경우 int cl_product_count =
			 * cartDTO.getProduct_count(); int chk_product_count =
			 * cartCheck.getProduct_count();
			 * cartDTO.setProduct_count(cl_product_count+chk_product_count);
			 * shopDao.editCart(cartDTO); return "장바구니에 이미 동일한 상품이 있습니다. 수량이 추가되었습니다."; }
			 * else { //장바구니에 동일 상품이 없는 경우 int orderID =
			 * shopDao.pickOrder(memberDTO).getOrder_id(); cartDTO.setOrder_id(orderID);
			 * shopDao.addCart(cartDTO); return "장바구니에 상품이 추가되었습니다."; }
			 */
//		} else {
//			return "오류가 발생했습니다.";
		}
		return "예외 발생";
	}
	
	public List<CartDTO> listCartProcess(MemberDTO memberDTO){
		//먼저 해당 멤버의 order를 가져옵니다.
		OrderInfoDTO orderInfoDTO = shopDao.pickOrder(memberDTO);
		//이제 불러온 order에 해당되는 cart 목록을 전부 가져옵니다.
		return shopDao.listCart(orderInfoDTO);
	}

	@Override
	public void deleteCartProcess(CartDTO cartDTO) {
		shopDao.deleteCart(cartDTO);
	}

	@Override
	public void editCartProcess(CartDTO cartDTO) {
		shopDao.editCart(cartDTO);
		
	}

	@Override
	public OrderInfoDTO getOrderProcess(MemberDTO memberDTO) {
		return shopDao.pickOrder(memberDTO);
	}

}
