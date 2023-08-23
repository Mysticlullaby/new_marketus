package board.service;

import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.PageDTO;

public class BoardServiceImp implements BoardService {
	
	private BoardDAO boardDao;
	
	public BoardServiceImp() {
		
	}
	
	

	public BoardDAO getBoardDao() {
		return boardDao;
	}



	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}



	@Override
	public int countProcess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDTO contentProcess(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProcess(BoardDTO dto, String urlpath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProcess(int num, String urlpath) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String fileSelectprocess(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
