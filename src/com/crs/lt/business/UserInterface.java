package com.crs.lt.business;

public interface UserInterface {

	String getRole(String userId);
	boolean verifyCredentials(String userId, String password);
	boolean updatePassword(String userId, String newPassword);
}
