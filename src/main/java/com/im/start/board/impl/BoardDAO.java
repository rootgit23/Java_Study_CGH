package com.im.start.board.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.im.start.util.Pager;

public interface BoardDAO {
	
	//글의 총개수
	public Long getCount(Pager pager) throws Exception;
	
	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	public int setAddFile(List<BoardFileDTO> ar) throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	public int setFileDelete(BoardFileDTO boardFileDTO,ServletContext servletContext) throws Exception;
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception;

}
