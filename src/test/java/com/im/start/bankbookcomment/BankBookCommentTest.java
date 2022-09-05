package com.im.start.bankbookcomment;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.im.start.MyAbstractTest;
import com.im.start.bankbook.BankBookCommentDAO;

public class BankBookCommentTest extends MyAbstractTest {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setAddComment() throws Exception {
		int result = bankBookCommentDAO.setAddComment();
		assertEquals(1, result);
	}

}
