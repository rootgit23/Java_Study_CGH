package com.im.start.board.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.im.start.util.Pager;

public interface BoardService {
	
	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글입력
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files,ServletContext servletContext) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO,MultipartFile [] files, ServletContext servletContext) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	public int setFileDelete(BoardFileDTO boardFileDTO,ServletContext servletContext) throws Exception;

}
