package com.im.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	@Test
	public void getListTest() throws Exception{
		List<BoardDTO> ar = noticeDAO.getList();
		assertEquals(0, ar.size());
	}

}
