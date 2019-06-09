package com.paraboliccheck.model;

public class PushBulletModel {
	
	private String body;
	private String title;
	private String type;
	private String email;
	public PushBulletModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PushBulletModel(String body, String title, String type, String email) {
		super();
		this.body = body;
		this.title = title;
		this.type = type;
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "PushBulletModel [body=" + body + ", title=" + title + ", type=" + type + ", email=" + email + "]";
	}
	
	

}
