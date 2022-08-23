package com.im.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.im.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList();
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}
	
	@RequestMapping(value="detail",method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("qna/detail");
		return mv;
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "qna/add";
	}
	
	@RequestMapping(value="add",method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setAdd(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("qna/update");
		return mv;
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardDTO);
		mv.setViewName("redirect:./detail?num="+boardDTO.getNum());
		return mv;
	}
	
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
