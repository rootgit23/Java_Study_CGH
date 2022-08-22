package com.im.start.bankaccount;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.im.start.bankbook.BankBookDTO;

@Component
public class BankAccountDTO {

	private int accountNum;
	private String userID;
	private long bookNum;
	private Date accountDate;
	private BankBookDTO bankBookDTO;
	
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public long getBookNum() {
		return bookNum;
	}
	public void setBookNum(long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
}
