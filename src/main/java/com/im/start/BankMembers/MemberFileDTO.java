package com.im.start.BankMembers;

import com.im.start.file.FileDTO;

public class MemberFileDTO extends FileDTO{
	private String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
