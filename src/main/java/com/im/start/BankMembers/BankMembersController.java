package com.im.start.BankMembers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.bankaccount.BankAccountDTO;

@Controller
@RequestMapping(value="/member/*")
public class BankMembersController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "/member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		// "redirect:다시 접속할 URL(절대경로,상대경로)"
		return "redirect:../";
	}
	
	@RequestMapping(value = "logOut" , method = RequestMethod.GET)
	public String logOut(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public String getList(HttpSession session,Model model) throws Exception{
		System.out.println("Member get List 실행");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		//Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
		//model.addAttribute("map", map);
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		model.addAttribute("dto", bankMembersDTO);
		//List<BankAccountDTO> ar = AccountService.getList(bankMembersDTO);
		//model.addAttribute("dto", bankMembersDTO);
		//model.addAttribute("list", ar);
		
		return "/member/myPage";
		
	}
	
	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public String agree() {
		return "/member/agree";
	}
	
	//Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		return "/member/join";
	}
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(String user_name,String password,String name, String email, String phone, MultipartFile photo) throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUser_name(user_name);
		bankMembersDTO.setPassword(password);
		bankMembersDTO.setName(name);
		bankMembersDTO.setEmail(email);
		bankMembersDTO.setPhone(phone);
		System.out.println("업로드시 파일명 :" + photo.getOriginalFilename());
		System.out.println("업로드시 파라미터명 :" + photo.getName());
		System.out.println("업로드하는 파일 크기 : " + photo.getSize());
		int result = bankMembersService.setJoin(bankMembersDTO,photo);
		if(result == 1) {
			//System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		System.out.println("조인 Post 실행");
		
		//로그인폼 페이지로 이동
		//redirect
		return "redirect:./login.file";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("search GET 실행");
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getSearchByID(String search,Model model) throws Exception {
		System.out.println("search Post 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
	}

}
