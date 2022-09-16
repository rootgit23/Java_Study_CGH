package com.im.start.board.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.im.start.board.impl.BoardDTO;
import com.im.start.board.impl.BoardFileDTO;
import com.im.start.board.impl.BoardService;
import com.im.start.file.File;
import com.im.start.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
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
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files,ServletContext servletContext) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		String realPath = servletContext.getRealPath("resources/upload/notice");
		File file = new File();
		List<BoardFileDTO> ar = file.setFile(boardDTO, files, realPath);
		noticeDAO.setAddFile(ar);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO,MultipartFile [] files, ServletContext servletContext) throws Exception {
	    	// TODO Auto-generated method stub
			String path="resources/upload/notice";
			int result = noticeDAO.setUpdate(boardDTO);
			List<BoardFileDTO> ar = new ArrayList<BoardFileDTO>();
			
				
			if(result<1) {
				return result;
			}
				
			for(MultipartFile multipartFile: files) {
				if(multipartFile.isEmpty()) {
					continue;
				}
				File file = new File();
				String fileName = file.saveFile(servletContext,path, multipartFile);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
					boardFileDTO.setFileName(fileName);
					boardFileDTO.setOriName(multipartFile.getOriginalFilename());
					boardFileDTO.setNum(boardDTO.getNum());
					ar.add(boardFileDTO);
			}
			noticeDAO.setAddFile(ar);
				
			return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO,ServletContext servletContext) throws Exception {
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		int result = noticeDAO.setFileDelete(boardFileDTO,servletContext);
		String path = "resources/upload/notice";
		if(result > 0) {
			File file = new File();
			file.deleteFile(servletContext, path, boardFileDTO);
		}
		return result;
	}
	

}
