package com.tyan.ba.entity.audio;

import java.util.Date;

public class Audio {
	private String name;
	private String filename;
	private int categoryId;
	private int playtime;
	private int bitrate;
	private Date modifiedDate;
	private Date createDate;
	private String description;
	private int authority;//权限
	
	public Audio() {
		// TODO Auto-generated constructor stub
	}
	
	public Audio(String name, String filename, int categoryId, int playtime,
			int bitrate, Date modifiedDate, Date createDate,
			String description, int authority) {
		super();
		this.name = name;
		this.filename = filename;
		this.categoryId = categoryId;
		this.playtime = playtime;
		this.bitrate = bitrate;
		this.modifiedDate = modifiedDate;
		this.createDate = createDate;
		this.description = description;
		this.authority = authority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPlaytime() {
		return playtime;
	}
	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}
	public int getBitrate() {
		return bitrate;
	}
	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	
}
