package com.crs.lt.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.constant.SQLQueryConstant;
import com.crs.lt.utils.DBUtils;

/**
 * @author user203
 *
 */
public class ProfessorDaoOperation implements ProfessorDOAInterface {

	@Override
	public List<Course> getCoursesByProfessor(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnrolledStudent> getEnrolledStudents(String CourseId) {
		// TODO Auto-generated method stub

		Connection connection=DBUtils.getConnection();
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.GET_ENROLLED_STUDENT);
			statement.setString(1, CourseId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				//public EnrolledStudent(String courseCode, String courseName, int studentId) 
				enrolledStudents.add(new EnrolledStudent(results.getString("courseCode"),results.getString("courseName"),results.getString("studentId")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
		return enrolledStudents;

	}

	@Override
	public Boolean addGrade(String studentId, String courseCode, String grade) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.ADD_GRADE);
			
			statement.setString(1, grade);
			statement.setString(2, courseCode);
			statement.setString(3, studentId);
			
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
	public String getProfessorById(String profId) {
		// TODO Auto-generated method stub
		return null;
	}

}
