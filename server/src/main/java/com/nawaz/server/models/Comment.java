package com.nawaz.server.models;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	private int id;	
	private int userId;
	private String locationUuid;
	private String text;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLocationUuid() {
		return locationUuid;
	}
	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
