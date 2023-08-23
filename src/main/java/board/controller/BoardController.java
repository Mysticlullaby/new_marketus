package board.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import board.dto.BoardDTO;
import board.dto.PageDTO;
import board.service.BoardService;
import member.dto.AuthInfo;

//http://localhost:8090/marketus/board/list.do

@Controller
public class BoardController {
	private BoardService boardService;
	private PageDTO pdto;
	
	public BoardController() {
		
	}
	

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value="/board/list.do")
//	public String jBoard() {
//		return "board";
//	}
	public ModelAndView listExecute(@ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		
		int totalRecord = boardService.countProcess(); //현재 테이블에 저장된 전체 글 갯수
		if (totalRecord >= 1) {
			if (pv.getCurrentPage()==0)
				pv.setCurrentPage(1);
			
			this.pdto = new PageDTO(pv.getCurrentPage(), totalRecord);
			mav.addObject("pv", this.pdto);
			mav.addObject("boardList", boardService.listProcess(pdto));
		}
		
		mav.setViewName("board/list");
		return mav;
	}//end listExecute()
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public ModelAndView writeExecute(@ModelAttribute("dto") BoardDTO dto, @ModelAttribute("pv") PageDTO pv, ModelAndView mav) {
		mav.setViewName("board/write");
		return mav; //입력한 폼을 가져온다.
	}//end writeExecute()
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String writeProExecute(BoardDTO dto, PageDTO pv, HttpServletRequest req, HttpSession session, RedirectAttributes ratt) {
		MultipartFile file = dto.getFilename();
		
		if (!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, req);
			dto.setAttachment(random + "_" + file.getOriginalFilename());
		}
		dto.setIp(req.getRemoteAddr()); //답변글과 제목글이 여기까지 같다
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setMember_id(authInfo.getMember_id());
		
		boardService.insertProcess(dto);
		
		if(dto.getRef() !=0)
			ratt.addAttribute("currentPage", pv.getCurrentPage());
		return "redirect:/board/list.do";
	}//end writeProExecute()
	
	@RequestMapping("/board/view.do")
	public ModelAndView viewExecute(int num, int currentPage, ModelAndView mav) {
		mav.addObject("dto", boardService.contentProcess(num));
		mav.addObject("num", num);
		mav.setViewName("board/view");
		return mav;
	}//end viewExecute()
	
	@RequestMapping(value="/board/contentsdownload.do")
	public ModelAndView downloadExecute(int num, ModelAndView mav) {
		mav.addObject("num", num);
		mav.setViewName("download");
		return mav;
	}//end downloadExecute()
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public ModelAndView updateExecute(int num, int currentPage, ModelAndView mav) {
		mav.addObject("dto", boardService.updateSelectProcess(num));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("board/update");
		return mav;
	}//end updateExecute()
	
	@RequestMapping(value="/board/update.do", method=RequestMethod.POST)
	public String updateExecute(BoardDTO dto, int currentPage, HttpServletRequest request, RedirectAttributes ratt) {
		MultipartFile file = dto.getFilename();
		if(!file.isEmpty()) {
			UUID random = FileUpload.saveCopyFile(file, request);
			dto.setAttachment(random + "_" + file.getOriginalFilename());
		}
		
		boardService.updateProcess(dto, FileUpload.urlPath(request));
		
		ratt.addAttribute("currentPage", currentPage);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/board/delete.do")
	public String deleteExecute(int num, int currentPage, HttpServletRequest request, RedirectAttributes ratt) {
		ratt.addAttribute("currentPage", currentPage);
		boardService.deleteProcess(num, FileUpload.urlPath(request));
		return "redirect:/board/list.do";
	}//삭제
	
}//end class
	
	

