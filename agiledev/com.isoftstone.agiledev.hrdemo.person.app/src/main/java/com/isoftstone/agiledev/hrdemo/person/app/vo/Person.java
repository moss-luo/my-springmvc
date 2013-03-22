package com.isoftstone.agiledev.hrdemo.person.app.vo;

import java.util.List;

public class Person {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String curr_address;
	private String company_name;
	private String identity_card_num;
	private String remarks;
	private List<Card> card;
	private School school;
	private int school_id;
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
	public String getCurr_address() {
		return curr_address;
	}
	public void setCurr_address(String curr_address) {
		this.curr_address = curr_address;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getIdentity_card_num() {
		return identity_card_num;
	}
	public void setIdentity_card_num(String identity_card_num) {
		this.identity_card_num = identity_card_num;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
}
