package com.tyan.ba.vo;

public class AudioUK {
	private String name;
	private int categoryId;
	
	public AudioUK(String name, int categoryId) {
		super();
		this.name = name;
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
