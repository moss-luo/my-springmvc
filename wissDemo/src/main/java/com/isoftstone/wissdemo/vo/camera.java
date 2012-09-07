package com.isoftstone.wissdemo.vo;

public class camera {
	
	private int id;
	private String cname;
	private String ctype;
	private int count;
	public camera (int id,String cname,String ctype,int count)
	{
		this.id=id;
		this.cname=cname;
		this.ctype=ctype;
		this.count=count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
