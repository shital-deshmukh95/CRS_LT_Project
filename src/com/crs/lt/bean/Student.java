package com.crs.lt.bean;

public class Student extends User {

	public Student(String userId, String name, String role, String password) {
		super(userId, name, role, password);
		// TODO Auto-generated constructor stub
	}
	private String branch;
	private String studentId;
	private int batch;
	boolean isApproved;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
