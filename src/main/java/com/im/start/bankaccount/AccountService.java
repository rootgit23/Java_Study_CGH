package com.im.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	
	public List<BankAccountDTO> getList(){
		
		
		return bankAccountDAO.getList();
	}
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		
		return bankAccountDAO.add(bankAccountDTO);
	}
	

}
