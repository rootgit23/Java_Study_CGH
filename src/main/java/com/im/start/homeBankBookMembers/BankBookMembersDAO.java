package com.im.start.homeBankBookMembers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int setJoin(String userName) throws Exception {
		return 1;
	}
	public Object getLogin(String userName, String password) throws Exception{
		return null;
	}
	public List<Object> getSearch(String search) throws Exception{
		ArrayList<Object> ar = new ArrayList<Object>();
		return ar;
	}
}
