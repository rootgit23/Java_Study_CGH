package com.im.start.BankMembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.bankaccount.BankAccountDAO;
import com.im.start.bankaccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;
	//@Autowired
	//private BankAccountDAO bankAccountDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception {
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("RealPath : "+realPath);
		
		File file = new File(realPath);
		
		//if(photo.getSize() != 0) {
			
		//}
		
		if(!photo.isEmpty()) {
			
			if(file.exists()) {
				file.mkdirs();
			}
			
			String fileName = UUID.randomUUID().toString();
			System.out.println(fileName);
			
			Calendar ca = Calendar.getInstance();
			Long time = ca.getTimeInMillis();
			
			fileName = fileName+"_"+photo.getOriginalFilename();
			
			file = new File(file, fileName);
			
			photo.transferTo(file);
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			memberFileDTO.setUser_name(bankMembersDTO.getUser_name());
			bankMembersDAO.setAddFile(memberFileDTO);
		}
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
