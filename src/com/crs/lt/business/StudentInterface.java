package com.crs.lt.business;

public interface StudentInterface {
	public String register(String name,String userID,String password,int batch,String branch,String address); 
	public String getStudentId(String userId);
    public boolean isApproved(String studentId);

}
