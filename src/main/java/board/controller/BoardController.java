package board.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dto.PageDTO;
import board.service.BoardService;

//http://localhost:8090/marketus/board/list.do

@Controller
public class BoardController {
	private BoardService boardService;
	private PageDTO pdto;
	
	public BoardController() {
		
	}
	
	@RequestMapping(value="/board/list.do")
	public String jBoard() {
		return "board";
	}
	

//	
//	public BoardController() {
//		
//	}
//	
//	public void setBoardService(BoardService boardService) {
//		this.boardService = boardService;
//	
//	
//	}
//	
//	@RequestMapping(value="/board/list.do")
//	public ModelAndView listExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
//		System.out.println("pv:" + pv.getCurrentPage());
//		
//		int totalRecord = boardService.countProcess();
//		if (totalRecord >= 1) {
//			if (pv.getCurrentPage()==0)
//				pv.setCurrentpage(1);
//			
//			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
//			mav.addObject("pv", this.pdto);
//			
//			mav.addObject("boardList", boardService.listProcess(pdto));
//		}
	
//	mav.setViewName("board/list");
	
//		
//	}//end listExecute()
	
//	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
//	public String writeProExecute(BoardDTO dto, PageDTO pv, HTTPServlet)

}
