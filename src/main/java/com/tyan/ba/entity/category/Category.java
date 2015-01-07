package com.tyan.ba.entity.category;

import java.util.Date;

import com.tyan.ba.conf.BAConstant;

public class Category {
	private static String basePath = BAConstant.baseStoragePath + "/AudioMp3/";
	
	private int categoryId;
	private String name;
	private String dirPath;
	private String coverPath;
	private String description;
	private Date createDate;
	private Date modifiedDate;
	private int authority;//权限
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	//warining : 提到service层做
	public Category(String name, String description) {
		this.name = name;
		this.dirPath = Category.basePath + name;
		this.description = description;
		this.createDate = new Date();
		this.modifiedDate = new Date();
	}
	
	public String getCoverPath() {
		return coverPath;
	}
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}

	
}
