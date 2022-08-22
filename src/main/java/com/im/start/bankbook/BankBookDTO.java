package com.im.start.bankbook;

import java.util.List;

import org.springframework.stereotype.Component;

import com.im.start.bankaccount.BankAccountDTO;

@Component
public class BankBookDTO {

	private long Book_Num;
	private String Book_Name;
	private double Book_Rate;
	private boolean Book_Sale;
	private String bookContents;
	private List<BankAccountDTO> bankAccountDTO;
	
	
	
	public List<BankAccountDTO> getBankAccountDTO() {
		return bankAccountDTO;
	}
	public void setBankAccountDTO(List<BankAccountDTO> bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}
	public long getBook_Num() {
		return Book_Num;
	}
	public void setBook_Num(long book_Num) {
		Book_Num = book_Num;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public double getBook_Rate() {
		return Book_Rate;
	}
	public void setBook_Rate(double book_Rate) {
		Book_Rate = book_Rate;
	}
	public boolean isBook_Sale() {
		return Book_Sale;
	}
	public void setBook_Sale(boolean book_Sale) {
		Book_Sale = book_Sale;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	
	
}
