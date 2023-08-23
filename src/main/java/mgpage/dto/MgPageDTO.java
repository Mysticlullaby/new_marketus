package mgpage.dto;

public class MgPageDTO {
	private String state; // 주문상태(신규,배송상태)
	private int order_id;// 주문번호
	private String member_id;
	private String proguct_id;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getProguct_id() {
		return proguct_id;
	}
	public void setProguct_id(String proguct_id) {
		this.proguct_id = proguct_id;
	}
	
}// end class
