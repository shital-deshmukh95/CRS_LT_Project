package com.crs.lt.doa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.Catalog;
import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.constant.SQLQueryConstant;
import com.crs.lt.utils.DBUtils;

public class AdminDoaOperation implements AdminDOAInterface {
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	@Override
	public List<Catalog> viewCourses() {
		// TODO Auto-generated method stub

		statement = null;
		List<Catalog> courseList = new ArrayList<>();
		try {
			
			
			statement = connection.prepareStatement(SQLQueryConstant.VIEW_COURSE_CATALOG);
			//statement.setInt(1, catalogId);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Catalog catalog = new Catalog();
				catalog.setCourseCode(resultSet.getString(1));
				catalog.setCourseName(resultSet.getString(2));
				catalog.setDescription(resultSet.getString(3));
				courseList.add(catalog);
				
			}
			
			System.out.println("Number of courses in the Catalog are : " + courseList.size());
			
		}catch(SQLException se) {
			
			se.printStackTrace();
			
		}
		
		return courseList; 
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCourse(String coursecode) {
		statement = null;
		try {
			//String sql = "delete from Course where courseCode = ?";
			statement = connection.prepareStatement(SQLQueryConstant.DELETE_COURSE_FROM_CATALOG);
			
			statement.setString(1,coursecode);
			int row = statement.executeUpdate();
			
			System.out.println(row + " entries deleted.");
			if(row == 0) {
				System.out.println(coursecode + " not in catalog!");
				
			}

			System.out.println("Course with courseCode: " + coursecode + " deleted.");
			
		}catch(SQLException se) {
			
			se.printStackTrace();
		}
		
	}
		
	

	@Override
	public void addCourse(Catalog course) {
		// TODO Auto-generated method stub
		statement = null;
		try {
			
			//String sql = "insert into Course(courseCode, courseName, availableSeats, instructorId) values (?, ?, ?, ?)";
			statement = connection.prepareStatement(SQLQueryConstant.ADD_COURSE_CATALOG);
			
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			statement.setString(3, course.getDescription());

			int row = statement.executeUpdate();
			
			System.out.println(row + " course added");
			if(row == 0) {
				System.out.println("Course with courseCode: " + course.getCourseCode() + "not added ");
				
			}
			
			System.out.println("Course with courseCode: " + course.getCourseCode() + " is added "); 
			
		}catch(SQLException se) {
			
			se.printStackTrace();
			
		}
	}

}
