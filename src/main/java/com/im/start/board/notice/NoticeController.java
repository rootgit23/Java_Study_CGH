package com.im.start.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.im.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList();
		mv.addObject("list", ar);
		mv.setViewName("notice/list");
		return mv;
		
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO,Model model) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "notice/detail";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "notice/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("notice/update");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:./detail?num="+boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list";
	}
	
}
