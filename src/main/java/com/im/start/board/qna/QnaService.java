package com.im.start.board.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		System.out.println(boardDTO.getNum());
		QnaDTO parent = (QnaDTO)boardDTO;
		qnaDTO.setRef(parent.getRef());
		System.out.println(qnaDTO.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		String realPath = servletContext.getRealPath("resources/upload/qna");
		List<BoardFileDTO> ar = new ArrayList<BoardFileDTO>();
		for(int i=0; i<files.length; i++) {
			File file = new File(realPath);
			if(!files[i].isEmpty()) {
				if(!file.exists()) {
					file.mkdirs();
				}
				String fileName = UUID.randomUUID().toString();
				fileName = fileName+"_"+files[i].getOriginalFilename();
				file = new File(file,fileName);
				files[i].transferTo(file);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setNum(boardDTO.getNum());
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(files[i].getOriginalFilename());
				ar.add(boardFileDTO);
			}
		}
		qnaDAO.setAddFile(ar);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
}
