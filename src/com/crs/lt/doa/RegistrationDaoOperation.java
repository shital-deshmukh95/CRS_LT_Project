package com.crs.lt.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.visitor.Reifier;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Grade;
import com.crs.lt.bean.Payment;
import com.crs.lt.bean.RegisteredCourse;
import com.crs.lt.bean.Student;
import com.crs.lt.bean.User;
import com.crs.lt.constant.SQLQueryConstant;
import com.crs.lt.utils.DBUtils;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author user203
 *
 */
public class RegistrationDaoOperation implements RegistrationDAOInterface {
	
	private PreparedStatement stmt = null;
	

	
	/* Method to add course for student 
	 * @param courseCode: Course code
	 * @param studentId: Student ID
	 */
	@Override
	public boolean addCourse(String courseCode, String studentId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		boolean courseAdded = false;
//			for (Course course: courseList){
//				if(course.getCourseCode().equals(courseCode) && !registeredCoursesList.contains(courseCode)){
//					RegisteredCourse registeredCourse = new RegisteredCourse(course, studentId, "A");
//					registeredCoursesList.add(registeredCourse);
//					courseAdded = true;
//				}
//				else 
//					courseAdded = false;
//			}
//		
		try 
		{
			stmt = conn.prepareStatement(SQLQueryConstant.ADD_COURSE_FOR_STUDENT);
			stmt.setString(1, studentId);
			stmt.setString(2, courseCode);
			stmt.setString(3, "-");
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(SQLQueryConstant.DECREMENT_AVAILABLE_SEATS);
			stmt.setString(1, courseCode);
			stmt.executeUpdate();
			return true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
		
		
	}

	/* Method to add course for student 
	 *
	 * @param studentId: Student ID
	 */
	@Override
	public void setRegistrationStatus(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		try 
		{
			stmt = conn.prepareStatement(SQLQueryConstant.SET_REGISTRATION_STATUS);
			stmt.setString(1, studentId);
			stmt.executeUpdate();

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();

		} 
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/* Method to add course for student 
	 * 
	 * @param studentId: Student ID
	 * return status
	 */
	@Override
	public boolean getRegistrationStatus(String studentId) {
		// TODO Auto-generated method stub
//		boolean isRegistered = false;
//		for (RegisteredCourse course : registeredCoursesList){
//			if(course.getStudentId().equals(studentId)){
//				 isRegistered = true;
//			}
//			else 
//				 isRegistered = false;
//		}
//		return isRegistered;
		
		Connection conn = DBUtils.getConnection();
		boolean status = false;
		try 
		{
			stmt = conn.prepareStatement(SQLQueryConstant.GET_REGISTRATION_STATUS);
			stmt.setString(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			status = rs.getBoolean(1);	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();

		} 
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}

	/* Method to add course for student 
	 * 
	 * @param studentId: Student ID
	 * return boolean
	 */
	@Override
	public boolean getPaymentStatus(String studentId) {
		// TODO Auto-generated method stub
//		boolean paymentStatus = false;
//		for (Payment payment: payments){
//			if(payment.getStud().getUserId().equals(studentId)){
//				paymentStatus = payment.isStatus();
//			}
//			paymentStatus = payment.isStatus();
//		}
//		return paymentStatus;
		{
			Connection conn = DBUtils.getConnection();
			boolean status = false;
			try 
			{
				stmt = conn.prepareStatement(SQLQueryConstant.GET_PAYMENT_STATUS);
				stmt.setString(1, studentId);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				status = rs.getBoolean(1);
				//System.out.println(status);	
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();

			} 
			finally
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return status;
	}

	}

	/* Method to view registered courses
	 *
	 * @param studentId: Student ID
	 * return list of registered course
	 */
	@Override
	public List<Course> viewRegisteredCourses(String studentId) {
		// TODO Auto-generated method stub
		// List<Course> registeredCourseListNew = new ArrayList<>();
		// for (RegisteredCourse registeredCourse: registeredCoursesList){
		// if(registeredCourse.getStudentId().equals(studentId)){
		// registeredCourseListNew.add(new Course(registeredCourse
		// .getCourse().getCourseCode(), registeredCourse
		// .getCourse().getCourseName(), registeredCourse
		// .getCourse().getInstructorId(), registeredCourse
		// .getCourse().getAvailable_seats()));
		// }
		// }
		// return registeredCourseListNew;

		Connection conn = DBUtils.getConnection();
		List<Course> registeredCourseList = new ArrayList<>();
		try {
			stmt = conn
					.prepareStatement(SQLQueryConstant.VIEW_REGISTRATION_COURSE);
			stmt.setString(1, studentId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				registeredCourseList.add(new Course(rs.getString("courseCode"),
						rs.getString("courseName"),
						rs.getString("instructorId"), rs.getInt("availableSeats")));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return registeredCourseList;
	}
	
	/* Method to view course
	 *
	 * @param studentId: Student ID
	 * return list of available courses
	 */

	@Override
	public List<Course> viewCourses(String studentId) {
		// TODO Auto-generated method stub
		List<Course> availableCourseList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		
		try 
		{
			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_COURSE);
			stmt.setString(1, studentId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				availableCourseList.add(new Course(rs.getString("courseCode"), rs.getString("courseName"),
						rs.getString("instructorId"), rs.getInt("availableSeats")));

			}
			

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return availableCourseList;
		
	}

	/* Method to view grade card 
	 * 

	 * @param studentId: Student ID
	 * return list of grade card of the student
	 */

	@Override
	public List<Grade> viewGradeCard(String studentId) {
		// TODO Auto-generated method stub
		List<Grade> gradeList = new ArrayList<Grade>();
//		for (RegisteredCourse course : registeredCoursesList){
//			if(course.getStudentId().equals(studentId)){
//				String courseName = course.getCourse().getCourseName();
//				String courseCode = course.getCourse().getCourseCode();
//				String grade = course.getGrade();
//				Grade newGrade = new Grade(courseCode, courseName, grade);
//				gradeList.add(newGrade);
//			}
//		}
		return gradeList;
	}

	@Override
	public double calculateFee(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean dropCourse(String courseCode, String studentId,
			List<Course> registeredCourseList) {
		boolean courseDropped = false;
		Connection conn = DBUtils.getConnection();
		
		
		try
		{
			stmt = conn.prepareStatement(SQLQueryConstant.DROP_COURSE);
			stmt.setString(1, courseCode);
			stmt.setString(2, studentId);
			stmt.execute();
			
			stmt = conn.prepareStatement(SQLQueryConstant.INCREMENT_AVAILABLE_SEATS);
			stmt.setString(1, courseCode);
			stmt.execute();
			
			stmt.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	return false;
	
	}

	@Override
	public boolean isReportGenerated(String studentId) {
		// TODO Auto-generated method stub
		boolean reportGenerated=false;
//		for (RegisteredCourse registeredCourse: registeredCoursesList){
//			if (registeredCourse.getStudentId().equals(studentId) && !registeredCourse.getGrade().equals(null)){
//				return reportGenerated= true;
//			}
//			else 
//				reportGenerated = false;
//		}
		return reportGenerated;
	}

	@Override
	public void setPaymentStatus(String studentId) {
		// TODO Auto-generated method stub
		
	}

}
