package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import board.dto.BoardDTO;
import board.dto.PageDTO;

public class BoardDaoImp implements BoardDAO {
	
	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImp() {
		
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	public BoardDaoImp(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readCount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO content(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFile(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
