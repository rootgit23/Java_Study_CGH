package com.im.start.bankbook;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private ServletContext servletContext;
	
	
	public int setBankBook(BankBookDTO bankBookDTO,MultipartFile photo) throws Exception{
		int result = bankBookDAO.setBankBook(bankBookDTO);
		String realPath = servletContext.getRealPath("resources/upload/bankbook");
		File file = new File(realPath);
		if(!photo.isEmpty()) {
			System.out.println(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + photo.getOriginalFilename();
			file = new File(file, fileName);
			photo.transferTo(file);
			BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
			bankBookFileDTO.setBook_Num(bankBookDTO.getBook_Num());
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setOriName(photo.getOriginalFilename());
			bankBookDAO.setAddFile(bankBookFileDTO);
		}
		return result;
	}
	
	// bank book 조회 최신 순 
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
	
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		
		return bankBookDAO.delete(bankBookDTO);
	}
	
	
}
