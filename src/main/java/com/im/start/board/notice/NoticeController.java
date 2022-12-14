package com.im.start.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardFileDTO;
import com.im.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getPage());
	    //System.out.println(page);
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
	    mv.setViewName("board/list");
	    if(ar.size() != 0) {
	    	throw new Exception();
	    }
		return mv;
		
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO,Model model) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd(HttpSession session) throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		if(bankMembersDTO != null) {
			return "board/add";
			
		} else {
			return "redirect:../member/login";
		}
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO,MultipartFile [] files,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String message = "?????? ??????";
		String url = "./list";
		int result = noticeService.setAdd(boardDTO,files,session.getServletContext());
		if(result == 1) {
			message = "?????? ??????";
		}
		mv.addObject("result",result);
		mv.addObject("message",message);
		mv.addObject("url",url);
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO,MultipartFile [] files, HttpSession session) throws Exception{
		int result = noticeService.setUpdate(boardDTO,files,session.getServletContext());
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/errors/error_404");
		return mv;
	}
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int setFileDelete(BoardFileDTO boardFileDTO,HttpSession session) throws Exception{
		int result = noticeService.setFileDelete(boardFileDTO,session.getServletContext());
		return result;
	}
	
}
