package com.im.start.BankMembers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.file.File;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	//@Autowired
	//private BankAccountDAO bankAccountDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo,ServletContext servletContext) throws Exception {
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String realPath = servletContext.getRealPath("resources/upload/member");
		File file = new File();
	    MemberFileDTO memberFileDTO = file.setFile(bankMembersDTO, photo, realPath);
	    bankMembersDAO.setAddFile(memberFileDTO);
		return result;
	}
	
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	//public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		//Map<String, Object> map = new HashMap<String, Object>();
		//List<BankAccountDTO> ar = bankAccountDAO.getList(bankMembersDTO);
		//bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		//map.put("list", ar);
		//map.put("dto", bankMembersDTO);
		//return map;
	//}

}
