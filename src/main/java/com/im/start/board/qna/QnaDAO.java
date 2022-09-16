package com.im.start.board.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im.start.board.impl.BoardDAO;
import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardFileDTO;
import com.im.start.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.im.start.board.qna.QnaDAO.";
	
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setStepUpdate", qnaDTO);
	}
	
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd",boardDTO);
	}
	@Override
	public int setAddFile(List<BoardFileDTO> ar) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddFile", ar);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	@Override
	public Long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}
	
	@Override
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
