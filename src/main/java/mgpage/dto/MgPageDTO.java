package mgpage.dto;

public class MgPageDTO {
	private int Status; // 주문상태(신규,배송상태)
	private String InOrder;//신규주문(결제완료상태)
	private String InProgress; //배송중
	private String History; //배송완료
	private int Order_id;// 주문번호
	private String Member_id;
	private String Product_id;
		
	public String getInOrder() {
		return InOrder;
	}
	public void setInOrder(String inOrder) {
		InOrder = inOrder;
	}
	public String getInProgress() {
		return InProgress;
	}
	public void setInProgress(String inProgress) {
		InProgress = inProgress;
	}
	public String getHistory() {
		return History;
	}
	public void setHistory(String History) {
		this.History = History;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int Status) {
		this.Status = Status;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int Order_id) {
		this.Order_id = Order_id;
	}
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String Member_id) {
		this.Member_id = Member_id;
	}
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String Product_id) {
		this.Product_id = Product_id;
	}
	
}// end class
