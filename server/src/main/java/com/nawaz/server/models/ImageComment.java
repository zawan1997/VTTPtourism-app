package com.nawaz.server.models;

import org.springframework.data.annotation.Id;

public class ImageComment {
	@Id
	private int id;	
	private int userId;
	private String locationUuid;
	private String blobc;
	
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
	public String getBlobc() {
		return blobc;
	}
	public void setBlobc(String blobc) {
		this.blobc = blobc;
	}	
}
