package com.crs.lt.bean;

public class User {

	private String userId;
	private String name;
	private String role;
	private String password;
	
	
	public User(String userId, String name, String role, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
