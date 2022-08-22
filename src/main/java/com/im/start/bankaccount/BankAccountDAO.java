package com.im.start.bankaccount;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im.start.BankMembers.BankMembersDTO;


@Repository
public class BankAccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.im.start.bankaccount.BankAccountDAO.";
	
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		
		return sqlSession.insert(NAMESPACE+"add",bankAccountDTO);
	}
	
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList",bankMembersDTO);
	}
	
	
	
}
