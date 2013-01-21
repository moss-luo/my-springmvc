package com.isoftstone.luckydraw.vo;

public class Person {
	private int id;
	private String name;
	private int status;		//0表示未中奖，1表示已中奖
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
