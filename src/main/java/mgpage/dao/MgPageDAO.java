package mgpage.dao;

import mgpage.dto.MgPageDTO;

public interface MgPageDAO {
	public String state(MgPageDTO dto); // 주문상태(신규,배송상태)
	public MgPageDTO Order(int order_id);// 주문번호
	public MgPageDTO member_id(String member_id);
	public MgPageDTO product_id(String proguct_id);
}
