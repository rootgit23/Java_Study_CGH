package com.im.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardService;
import com.im.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount();
		pager.getNum(totalCount);
		pager.getRowNum();
		//System.out.println("Service page : " + page);
		//Long perPage = 10L;
		//Long startRow = (page-1) * perPage+1;
		//Long lastRow = page * perPage;
		//Map<String, Long> map = new HashMap<String, Long>();
		//map.put("startRow", startRow);
		//map.put("lastRow", lastRow);
		//System.out.println("StartRow : " + startRow);
		//System.out.println("LastRow : " + lastRow);
		
		//Long totalCount = noticeDAO.getCount();
		//Long totalPage = 0L;
		//if(totalCount%perPage == 0) {
			//totalPage = totalCount/perPage; 
		//}
		//else {
			//totalPage = totalCount/perPage + 1;
		//}
		//System.out.println(totalPage);
		
		//perBlock 한페이지에 출력할 번호
		//Long perBlock = 5L;
		//Long totalBlock = totalPage/perBlock;
		//if(totalPage % perBlock != 0) {
			//totalBlock++;
		//}
		
		//Long curBlock = page/perBlock;
		//if(curBlock != 0) {
			//curBlock++;
		//}
		
		//Long startNum = (curBlock-1) * perBlock + 1;
		//Long lastNum = curBlock*perBlock;
		
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
