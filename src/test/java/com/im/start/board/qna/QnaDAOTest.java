package com.im.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	//public void getList() throws Exception{
		 //List<BoardDTO> ar = qnaDAO.getList();
		 //assertEquals(0, ar.size());
	//}
	
	//@Test
	//public void getDetail() throws Exception{
		//BoardDTO boardDTO = new BoardDTO();
		//boardDTO.setNum(1L);
		//boardDTO = qnaDAO.getDetail(boardDTO);
		//assertNotEquals(0, boardDTO);
	//}
	
	//@Test
	//public void setAdd() throws Exception{
		//BoardDTO boardDTO = new BoardDTO();
		
		//boardDTO.setTitle("test");
		//boardDTO.setContents("test");
		//boardDTO.setWriter("test");
		//int result = qnaDAO.setAdd(boardDTO);
		//assertEquals(1, result);
	//}
	  //@Test
	  //public void setUpdate() throws Exception{
		  //BoardDTO boardDTO = new BoardDTO();
		  //boardDTO.setNum(2L);
		  //boardDTO.setContents("test1");
		  //boardDTO.setTitle("test1");
		  //int result = qnaDAO.setUpdate(boardDTO);
		  //assertEquals(1, result);
	  //}
	  @Test
	  public void setDelete() throws Exception{
		  BoardDTO boardDTO = new BoardDTO();
		  boardDTO.setNum(2L);
		  int result = qnaDAO.setDelete(boardDTO);
		  assertEquals(1, result);
	  }
	

}
