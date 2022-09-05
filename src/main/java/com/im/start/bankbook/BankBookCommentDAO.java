package com.im.start.bankbook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "com.im.start.bankbook.BankBookCommentDAO.";
	
	public int setAddComment() throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddComment");
	}

}
