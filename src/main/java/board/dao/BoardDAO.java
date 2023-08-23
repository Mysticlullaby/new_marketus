package board.dao;

import java.util.List;

import board.dto.BoardDTO;
import board.dto.PageDTO;

public interface BoardDAO {
	public int count();
	public List<BoardDTO> list(PageDTO pv);
	public void readCount(int num);
	public BoardDTO content(int num);
	public void reStepCount(BoardDTO dto);
	public void save(BoardDTO dto);
	public void update(BoardDTO dto);
	public void delete(int num);
	public String getFile(int num);

}//end interface
