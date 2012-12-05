package com.kingkewow.springmvc.model;

public class ComboboxData {
	private String id;
	private String text;
	
	public ComboboxData(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	public ComboboxData() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
