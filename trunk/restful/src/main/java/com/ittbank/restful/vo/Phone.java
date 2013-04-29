package com.ittbank.restful.vo;

import java.util.List;

public class Phone {
	private int age;
	private String id;
	private String imageUrl;
	private List<String> images;
	private String name;
	private String snippet;
	private String description;
	
	public Phone(){
		super();
	}

	public Phone(int age, String id, String imageUrl,
			String name, String snippet, String description) {
		super();
		this.age = age;
		this.id = id;
		this.imageUrl = imageUrl;
		this.name = name;
		this.snippet = snippet;
		this.description = description;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
