package com.im.start.BankMembers;

import java.util.List;

import com.im.start.bankaccount.BankAccountDTO;
import com.im.start.file.FileDTO;

public class BankMembersDTO {
	
	private String user_name;
	private String password;
	private String name;
	private String email;
	private String phone;
	private MemberFileDTO memberFileDTO;
	private List<RollDTO> rollDTO;
	public List<RollDTO> getRollDTO() {
		return rollDTO;
	}
	public void setRollDTO(List<RollDTO> rollDTO) {
		this.rollDTO = rollDTO;
	}
	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}
	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}
	private List<BankAccountDTO> bankAccountDTO;
	public List<BankAccountDTO> getBankAccountDTO() {
		return bankAccountDTO;
	}
	public void setBankAccountDTO(List<BankAccountDTO> bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
