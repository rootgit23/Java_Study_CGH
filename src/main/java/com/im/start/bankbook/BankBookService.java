package com.im.start.bankbook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.file.File;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	
	@Autowired
	private ServletContext servletContext;
	
	public int setAddComment(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return bankBookCommentDAO.setAddComment(bankBookCommentDTO);
		
	}
	
	public int setBankBook(BankBookDTO bankBookDTO, MultipartFile photo) throws Exception{
		int result = bankBookDAO.setBankBook(bankBookDTO);
		String realPath = servletContext.getRealPath("resources/upload/member");
		File file = new File();
		BankBookFileDTO bankBookFileDTO = file.setFile(bankBookDTO, photo, realPath);
		return bankBookDAO.setAddFile(bankBookFileDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		
		return bankBookDAO.getList();
	}
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	
	//booknum 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	//
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.delete(bankBookDTO);
	}
	
}
