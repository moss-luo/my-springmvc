/**
 * 
 */
package com.kingkewow.springmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.kingkewow.springmvc.annotation.validator.CaseMode;
import com.kingkewow.springmvc.annotation.validator.CheckCase;

/**
 * @author Administrator
 * 
 */
public class UserModel {
	@NotBlank
	private String id;
	@Size(min=6,max=12)
	private String username;
	@NotNull
	private int age;
	@CheckCase(value = CaseMode.UPPER,message = "英文名必须大写!")
	private String enName;

	public UserModel(String id, String username, int age, String enName) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.enName = enName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	
}
