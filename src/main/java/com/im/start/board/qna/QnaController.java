package com.im.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.im.start.board.impl.BoardDTO;
import com.im.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "QNA";
	}
	
	@PostMapping("reply")
	public String setReply(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.setReply(qnaDTO);
		return "redirect:./list";
		
	}
	
	@GetMapping("reply")
	public ModelAndView setReply(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value="detail",method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
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
		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardDTO);
		mv.setViewName("redirect:./detail?num="+boardDTO.getNum());
		return mv;
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
