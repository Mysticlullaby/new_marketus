package board.service;

import java.io.File;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.PageDTO;

public class BoardServiceImp implements BoardService {
	
	private BoardDAO boardDao;
	
	public BoardServiceImp() {
		
	}

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public int countProcess() {
		return boardDao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		return boardDao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		//답변글이면
		if (dto.getRef() != 0) {
			boardDao.reStepCount(dto);
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level() + 1);
		}
		
		boardDao.save(dto);
		
	}

	@Override
	public BoardDTO contentProcess(int num) {
		boardDao.readCount(num);
		return boardDao.content(num);
	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		return boardDao.content(num);
	}

	@Override
	public void updateProcess(BoardDTO dto, String urlpath) {
		String filename=dto.getAttachment();
		
		//수정할 파일이 있으면
		if (filename != null) {
			
			String path = boardDao.getFile(dto.getNum());
			//기존 첨부 파일이 있으면
			if (path != null) {
				File file = new File (urlpath, path);
				file.delete(); //기존 첨부파일 지우는 작업
			}
		}
		boardDao.update(dto);
		
	}

	@Override
	public void deleteProcess(int num, String urlpath) {
		String path = boardDao.getFile(num);
		if(path != null) {
			File file = new File(urlpath, path);
			file.delete();
		}
		boardDao.delete(num);
	}

	@Override
	public String fileSelectprocess(int num) {

		return null;
	}
	

}
