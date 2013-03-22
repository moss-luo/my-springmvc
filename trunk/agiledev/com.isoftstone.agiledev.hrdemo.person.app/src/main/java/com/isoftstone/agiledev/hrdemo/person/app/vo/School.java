package com.isoftstone.agiledev.hrdemo.person.app.vo;

/**
 * @author luoting
 *
 */
public class School {
	private int id;
	private String address;
	private String name;
	
	public School() {
		super();
	}
	public School(int id, String address, String name) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
