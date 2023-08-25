package mgpage.dao;

import mgpage.dto.MgPageDTO;

public interface MgPageDAO {
	public int Status(MgPageDTO dto); // 주문상태(신규,배송상태)
	public MgPageDTO Order(int Order_id);// 주문번호
	public MgPageDTO Member_id(String Member_id);
	public MgPageDTO Product_id(String Product_id);
	public String InOrder(MgPageDTO dto);//신규주문(결제완료상태)
	public String InProgress(MgPageDTO dto); //배송중
	public String History(MgPageDTO dto); //배송완료
}
