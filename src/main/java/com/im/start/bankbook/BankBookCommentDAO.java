package com.im.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im.start.util.CommentPager;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "com.im.start.bankbook.BankBookCommentDAO.";
	
	public int setAddComment(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddComment",bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}
	
	public Long getCommentListTotalCount(CommentPager commentPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount", commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setCommentDelete", bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
	}

}
