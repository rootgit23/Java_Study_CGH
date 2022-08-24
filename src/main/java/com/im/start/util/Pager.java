package com.im.start.util;

public class Pager {
	
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long perPage;
	private Long perBlock;
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	public void getRowNum() throws Exception{
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void getNum(Long totalCount) throws Exception{
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage % this.getPerBlock() != 0) {
			totalBlock++;
		}
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock*this.getPerBlock();
	}
	
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return perPage;
	}


	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}


	public Long getPerBlock() {
		return perBlock;
	}


	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}


	
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPage() {
		if(this.page == null) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	

}
