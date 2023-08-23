package store.dao;

import java.util.List;

import javax.servlet.jsp.PageContext;

import store.dto.StoreDto;
import store.dto.pageDto;

public interface StoreDao {
	public List<StoreDto> sido(String store_adress);
	public StoreDto store_id(int store_id); 
	public StoreDto store_name(String store_number);
	public List<StoreDto> list(pageDto pv);
	public List<StoreDto> list(StoreDto sv);
	public StoreDto x(double x);
	public StoreDto y(double y);
	public StoreDto store_number(String storse_number);
	
	
}//end inter
