package store.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import store.dto.StoreDto;
import store.dto.pageDto;

public class StoreDaoImp implements StoreDao{
	private SqlSessionTemplate sqlSession;
	public StoreDaoImp() { } //생성자
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<StoreDto> sido(String store_adress){
		return sqlSession.selectList("store.store_name", store_adress);
	}//mapper클래스 sql의 namespace의 id값을 가져와서 실행

	@Override
	public StoreDto store_id(int store_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDto store_name(String store_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreDto> list(pageDto pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreDto> list(StoreDto sv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDto x(double x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDto y(double y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDto store_number(String storse_number) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}//public StoreDto 
