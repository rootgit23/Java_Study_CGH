package com.im.start.bankbook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.im.start.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "commentList" , method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCommentList(CommentPager commentPager) throws Exception{
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		return map;
	}
	
	//@RequestMapping(value = "commentList" , method = RequestMethod.GET)
	//public ModelAndView getCommentList(CommentPager commentPager) throws Exception{
		//ModelAndView mv = new ModelAndView();
		//List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		//System.out.println("Commentlist");
		//System.out.println(ar.size());
		//mv.addObject("commentList",ar);
		//mv.setViewName("common/commentList");
		//return mv;
	//}
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		System.out.println(bankBookCommentDTO.getContents());
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		return result;
	}
	
	
	@RequestMapping(value = "commentDelete", method = RequestMethod.POST)
	@ResponseBody
	public String setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	@ResponseBody
	public String setAddComment(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setAddComment(bankBookCommentDTO);
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
	//@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	//public ModelAndView setAddComment(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		//ModelAndView mv = new ModelAndView();
		//int result = bankBookService.setAddComment(bankBookCommentDTO);
		//mv.addObject("result",result);
		//mv.setViewName("common/ajaxResult");
		//return mv;
	//}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("list get 실행");
		
		
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list",ar);
		
	
	}
	
	
	
	
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public void Add() {
		System.out.println("add get 실행");
		
		
		
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String Add(BankBookDTO bankBookDTO,MultipartFile photo,HttpSession session) throws Exception {
		System.out.println("add post 실행");
		bankBookDTO.setBook_Num(System.currentTimeMillis());
		bankBookDTO.setBook_Sale(false);
		System.out.println(bankBookDTO.getBook_Num());
		
		
		bankBookService.setBankBook(bankBookDTO,photo,session.getServletContext());
		
		return "redirect:./list";
	}
	
	
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public void getDetail(BankBookDTO bankBookDTO,Model model) throws Exception {
		System.out.println("detail get 실행");
		
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("detail",bankBookDTO);
		
		
	}
	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO,Model model) throws Exception {
		System.out.println("update get 실행 ");
		
		//bankBookService.setUpdate(bankBookDTO);
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("update", bankBookDTO);
		
		
	}
	
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("update post 실행 ");
		
		
		bankBookService.setUpdate(bankBookDTO);
		
		
		return "redirect:./list";
		
	}
	
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String Delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Delete 실행 ");
		
		bankBookService.delete(bankBookDTO);
		
		return "redirect:./list";
	}
	
	
}
