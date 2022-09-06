package com.im.start.bankbook;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	public void setAddComment(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		int result = bankBookService.setAddComment(bankBookCommentDTO);
	}
	
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
	public String Add(BankBookDTO bankBookDTO,MultipartFile photo) throws Exception {
		System.out.println("add post 실행");
		bankBookDTO.setBook_Num(System.currentTimeMillis());
		bankBookDTO.setBook_Sale(false);
		System.out.println(bankBookDTO.getBook_Num());
		
		
		bankBookService.setBankBook(bankBookDTO,photo);
		
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
