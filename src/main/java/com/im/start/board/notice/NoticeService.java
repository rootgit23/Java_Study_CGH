package com.im.start.board.notice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardFileDTO;
import com.im.start.board.impl.BoardService;
import com.im.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
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
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		System.out.println(boardDTO.getNum());
		String realPath = servletContext.getRealPath("resources/upload/notice");
		System.out.println(realPath);
		List<BoardFileDTO> ar = new ArrayList<BoardFileDTO>();
		for(int i=0; i<files.length; i++) {
			File file = new File(realPath);
			if(!files[i].isEmpty()) {
				if(file.exists()) {
					file.mkdirs();
				}
				String fileName = UUID.randomUUID().toString();
				fileName = fileName+"_"+files[i].getOriginalFilename();
				file = new File(file, fileName);
				files[i].transferTo(file);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setNum(boardDTO.getNum());
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(files[i].getOriginalFilename());
				ar.add(boardFileDTO);
			}
		}
		noticeDAO.setAddFile(ar);
		return result;
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
