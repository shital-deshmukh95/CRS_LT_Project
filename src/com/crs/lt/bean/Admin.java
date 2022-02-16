package com.crs.lt.bean;

import java.util.Date;

public class Admin extends User{
	public Admin(String userId, String name, String role, String password) {
		super(userId, name, role, password);
		// TODO Auto-generated constructor stub
	}

	private Date dateOfJoining;

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	

}
