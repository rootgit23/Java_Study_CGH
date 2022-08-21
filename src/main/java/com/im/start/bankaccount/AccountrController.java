package com.im.start.bankaccount;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.bankbook.BankBookDTO;



@Controller
@RequestMapping(value = "/bankAccount/*")
public class AccountrController {

	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void getList(HttpSession session) throws Exception{
		System.out.println("Account get List 실행");
		
		
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("log");
		
		List<BankAccountDTO> ar = accountService.getList();
		
		
		// 미완
		
		
		
	}

	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session,BankBookDTO bankBookDTO) throws Exception {
		System.out.println("BANKACCOUNT 실행");
		
		System.out.println(bankAccountDTO.getBookNum());
		System.out.println(session.getAttribute("member"));
		System.out.println(bankBookDTO.getBook_Num());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserID(bankMembersDTO.getUser_name());
		bankAccountDTO.setBookNum(bankBookDTO.getBook_Num());
		
		
		
		int result = accountService.add(bankAccountDTO);
		
		System.out.println(result);
		System.out.println(bankAccountDTO.getUserID());
		System.out.println(bankAccountDTO.getBookNum());
		
		return "redirect:../bankbook/list";
		
	}
}
