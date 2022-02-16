package com.crs.lt.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.User;
import com.crs.lt.constant.SQLQueryConstant;
import com.crs.lt.utils.DBUtils;
import com.crs.lt.utils.DatabaseJDBC;

public class UserDaoOperation implements UserDAOInterface{

	 //List users;
	
	@Override
	public boolean verifyCredentials(String userId, String password) {
		// TODO Auto-generated method stub
//		boolean verified = false;
//		
//		for (User u : users) {
//			if(u.getPassword().equals(password)){
//				verified = true;
//			}
//		}
//		return verified;
		
		Connection connection = DBUtils.getConnection();
		try
		{
			//open db connection
			//String sql="select password from user where userId = ?";
			
			PreparedStatement stmt = null;
		      stmt = connection.prepareStatement(SQLQueryConstant.CHECK_CREDENTIALS_USER_DETAILS);
		      stmt.setString(1, userId); 
		      ResultSet resultSet = stmt.executeQuery();
			if(!resultSet.next())
				System.out.println("User with" + userId + "not found");

			else if(password.equals(resultSet.getString("password")))
			{
				
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public String getRole(String userId) {
		// TODO Auto-generated method stub
		Connection connection=DatabaseJDBC.getConnection();
		try {
			connection=DatabaseJDBC.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.GET_ROLE_TYPE);
			statement.setString(1, userId);
			ResultSet rs = statement.executeQuery();

			if(rs.next())
			{
				return rs.getString("roleType");
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		return null;
	}
}
