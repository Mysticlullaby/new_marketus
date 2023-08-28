package pay.dto;

import java.sql.Date;

public class PayDTO {
/* view단의 pay.jsp의 주문정보 데이터를 담아오는 class*/
 private int order_id;
 private char member_id;
 private Date order_date;
 private char delivery_address;
 private char status;
 private int total_price;
 private char payment;
 
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public char getMember_id() {
	return member_id;
}
public void setMember_id(char member_id) {
	this.member_id = member_id;
}
public Date getOrder_date() {
	return order_date;
}
public void setOrder_date(Date order_date) {
	this.order_date = order_date;
}
public char getDelivery_address() {
	return delivery_address;
}
public void setDelivery_address(char delivery_address) {
	this.delivery_address = delivery_address;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
public int getTotal_price() {
	return total_price;
}
public void setTotal_price(int total_price) {
	this.total_price = total_price;
}
public char getPayment() {
	return payment;
}
public void setPayment(char payment) {
	this.payment = payment;
}

 	
}//end class
