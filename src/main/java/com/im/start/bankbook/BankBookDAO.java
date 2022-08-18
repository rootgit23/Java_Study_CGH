package com.im.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {

	//
	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "com.im.start.bankbook.BankBookDAO.";
	
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setBankBook",bankBookDTO);
	}
	
	// bank book 조회 최신 순 
	public List<BankBookDTO> getList() throws Exception{
		
		
		
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		
		return 0;
	}
	
	
	//booknum 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"setUpdate",bankBookDTO);
	}
	//
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete",bankBookDTO);
	}
	
	
}
