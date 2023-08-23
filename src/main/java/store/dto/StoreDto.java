package store.dto;
//dto 1개에 1개의 레코드가 담김->여러개의 레코드를 담기위해 리스트로 환원
public class StoreDto {
	private int store_id;//매장id
	private String store_name;//매장명
	private String store_address;//매장 전체주소
	private double x; //위도
	private double y; //경도
	private String store_number; //매장번호
	private String adress; //도로명주소
	
	public StoreDto() {
		// TODO Auto-generated constructor stub
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getStore_number() {
		return store_number;
	}

	public void setStore_number(String store_number) {
		this.store_number = store_number;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}//end class
