package shop.dto;

public class CartDTO {
	private int cart_id;
	private int order_id;
	private int product_id;
	private int product_count;
	
	private ShopDTO shopDTO;
	
	public CartDTO() {
		
	}	

	public CartDTO(int cart_id, int order_id, int product_id, int product_count) {
		this.cart_id = cart_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_count = product_count;
	}

	public ShopDTO getShopDTO() {
		return shopDTO;
	}
	
	public void setShopDTO(ShopDTO shopDTO) {
		this.shopDTO = shopDTO;
	}
	
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	
	
}
