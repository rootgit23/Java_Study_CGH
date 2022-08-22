package com.im.start.BankMembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im.start.BankMembers.BankMembersDTO;
import com.im.start.bankaccount.BankAccountDTO;

@Repository
public class BankMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.im.start.BankMembers.BankMembersDAO.";
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getLogin",bankMembersDTO);
		
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin",bankMembersDTO);
	}
	

	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
			return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMyPage",bankMembersDTO);
	}

}
