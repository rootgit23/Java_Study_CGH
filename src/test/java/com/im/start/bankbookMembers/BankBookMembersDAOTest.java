package com.im.start.bankbookMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.homeBankBookMembers.BankBookMembersDAO;

public class BankBookMembersDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankBookMembersDAO bankBookMembersDAO;
	
	@Test
	public void setJoinTest() throws Exception{
		int result = bankBookMembersDAO.setJoin("df");
		throw new Exception();
		//assertEquals(1, result);
	}
	@Test
	public void getLogin() throws Exception{
		Object obj = bankBookMembersDAO.getLogin("df", "do");
		assertNull(obj);
	}
	@Test
	public void getSearch() throws Exception{
		List<Object> ar = bankBookMembersDAO.getSearch("ad");
		assertNotEquals(0, ar.size());
	}
}
