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


@Repository
public class BankAccountDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankaccount.BankAccountDAO.";
	
	public List<BankAccountDTO> getList(){
		
		
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		
		
		return sqlSession.insert(NAMESPACE+"add",bankAccountDTO);
	}
	
	
	
}
