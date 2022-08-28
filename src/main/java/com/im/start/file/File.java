package com.im.start.file;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.BankMembers.MemberFileDTO;
import com.im.start.bankbook.BankBookDTO;
import com.im.start.bankbook.BankBookFileDTO;
import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardFileDTO;

public class File {
	
	public List<BoardFileDTO> setFile(BoardDTO boardDTO, MultipartFile [] files,String realPath) throws Exception{
		List<BoardFileDTO> ar = new ArrayList<BoardFileDTO>();
		for(int i=0; i<files.length; i++) {
			java.io.File file = new java.io.File(realPath);
			if(!files[i].isEmpty()) {
				if(file.exists()) {
					file.mkdirs();
				}
				String fileName = UUID.randomUUID().toString();
				fileName = fileName+"_"+files[i].getOriginalFilename();
				file = new java.io.File(file, fileName);
				files[i].transferTo(file);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setNum(boardDTO.getNum());
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(files[i].getOriginalFilename());
				ar.add(boardFileDTO);
			}
		}
		return ar;
	}
	
	public MemberFileDTO setFile(BankMembersDTO bankMembersDTO,MultipartFile photo,String realPath) throws Exception{
		java.io.File file = new java.io.File(realPath);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		if(!photo.isEmpty()) {
			
			if(file.exists()) {
				file.mkdirs();
			}
			
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			file = new java.io.File(file,fileName);
			photo.transferTo(file);
			
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			memberFileDTO.setUser_name(bankMembersDTO.getUser_name());
		}
		return memberFileDTO;
	}
	
	public BankBookFileDTO setFile(BankBookDTO bankBookDTO,MultipartFile photo,String realPath) throws Exception{
		java.io.File file = new java.io.File(realPath);
		BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
		if(!photo.isEmpty()) {
			
			if(file.exists()) {
				file.mkdirs();
			}
			
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+photo.getOriginalFilename();
			file = new java.io.File(file,fileName);
			photo.transferTo(file);
			
			bankBookFileDTO.setFileName(fileName);
			bankBookFileDTO.setOriName(photo.getOriginalFilename());
			bankBookFileDTO.setBook_Num(bankBookDTO.getBook_Num());
		}
		return bankBookFileDTO;
	}

}
