package com.im.start.bankaccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.bankbook.BankBookDAO;
import com.im.start.bankbook.BankBookDTO;

public class BankAccountDAOTest extends MyAbstractTest {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getListTest() throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUser_name("AA");
		List<BankAccountDTO> ar =  bankAccountDAO.getList(bankMembersDTO);
		assertNotEquals(0, ar.size());
	}

}
