package com.kingkewow.springmvc.model;

public class ParamModel{
	
	private int page;
	private int pagesize;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartNum() {
		return pagesize*(page-1)+1;
	}
	public int getEndNum() {
		return pagesize*page;
	}
	
}
