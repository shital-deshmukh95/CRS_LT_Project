package com.crs.lt.business;

import com.crs.lt.bean.User;
import com.crs.lt.doa.UserDaoOperation;
import com.crs.lt.doa.UserDAOInterface;

public class UserService implements UserInterface {

	UserDAOInterface userDAOInterface = new UserDaoOperation();
	public boolean verifyCredentials(String userId, String password) {
		return userDAOInterface.verifyCredentials(userId, password);
	}
	@Override
	public String getRole(String userId) {
		// TODO Auto-generated method stub
		return userDAOInterface.getRole(userId);
	}
	@Override
	public boolean updatePassword(String userID, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
}
