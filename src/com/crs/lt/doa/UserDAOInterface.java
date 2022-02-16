package com.crs.lt.doa;

public interface UserDAOInterface {

	public boolean verifyCredentials(String userId,String password);
	public String getRole(String userId);
}
