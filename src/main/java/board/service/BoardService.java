package board.service;

import java.util.List;

import board.dto.BoardDTO;
import board.dto.PageDTO;

public interface BoardService {
	public int countProcess();
	public List<BoardDTO> listProcess(PageDTO pv);
	public void insertProcess(BoardDTO dto);
	public BoardDTO contentProcess(int board_id);
	public BoardDTO updateSelectProcess(int board_id);
	public void updateProcess(BoardDTO dto, String urlpath);
	public void deleteProcess(int board_id, String urlpath);
	public String fileSelectprocess(int board_id);

}
