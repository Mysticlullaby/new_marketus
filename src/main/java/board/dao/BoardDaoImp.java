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
		return sqlSession.selectOne("board.count");
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		return sqlSession.selectList("board.list", pv);

	}

	@Override
	public void readCount(int board_id) {
		sqlSession.update("board.readCount", board_id);
	}

	@Override
	public BoardDTO content(int board_id) {
		return sqlSession.selectOne("board.content", board_id);
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		sqlSession.update("board.reStepCount", dto);
		
	}

	@Override
	public void save(BoardDTO dto) {
		sqlSession.insert("board.save", dto);
		
	}

	@Override
	public void update(BoardDTO dto) {
		sqlSession.update("board.update", dto);
	}

	@Override
	public void delete(int board_id) {
		sqlSession.delete("board.delete", board_id);		
	}

	@Override
	public String getFile(int board_id) {
		return sqlSession.selectOne("board.getFile", board_id);
	}	

}
