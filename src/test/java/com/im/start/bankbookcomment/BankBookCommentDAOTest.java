package com.im.start.bankbookcomment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.bankbook.BankBookCommentDAO;


public class BankBookCommentDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setAddCommentTest() throws Exception {
		int result = bankBookCommentDAO.setAddComment();
		assertEquals(1, result);
	}

}
