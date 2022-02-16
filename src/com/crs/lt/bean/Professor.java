package com.crs.lt.bean;

import java.util.Date;

public class Professor extends User {

	public Professor(String userId, String name, String role, String password) {
		super(userId, name, role, password);
		// TODO Auto-generated constructor stub
	}
	private String professorID;
	private String department;
	private String designation;
	private Date doj;
	public String getProfessorID() {
		return professorID;
	}
	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	
}
