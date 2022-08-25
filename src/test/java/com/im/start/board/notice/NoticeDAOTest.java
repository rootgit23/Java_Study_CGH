package com.im.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.im.start.MyAbstractTest;
import com.im.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	//@Test
	//public void setAddTest() throws Exception{
		//for(int i=0; i<100; i++) {
			//NoticeDTO noticeDTO = new NoticeDTO();
			//noticeDTO.setTitle("title"+i);
			//noticeDTO.setContents("contents"+i);
			//noticeDTO.setWriter("writer"+i);
			//int result = noticeDAO.setAdd(noticeDTO);
			//if(i%10 == 0) {
				//Thread.sleep(500);
			//}
		//}
		//System.out.println("Finish!!!!");
	//}
	//@Test
	//public void getCountTest() throws Exception{
		//Long result = noticeDAO.getCount();
		//System.out.println(result);
	//}

}
