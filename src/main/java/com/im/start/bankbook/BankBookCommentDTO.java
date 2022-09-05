package com.im.start.bankbook;

import org.springframework.stereotype.Component;

import com.im.start.board.impl.CommentDTO;

@Component
public class BankBookCommentDTO extends CommentDTO {
	
	private Long Book_Num;

	public Long getBook_Num() {
		return Book_Num;
	}

	public void setBook_Num(Long book_Num) {
		Book_Num = book_Num;
	}

}
