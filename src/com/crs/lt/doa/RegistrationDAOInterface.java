/**
 * 
 */
package com.crs.lt.doa;

import java.sql.SQLException;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Grade;

/**
 * @author user203
 *
 */
public interface RegistrationDAOInterface {

	public boolean addCourse(String courseCode, String studentId);
	public void setRegistrationStatus(String studentId);
	public boolean getRegistrationStatus(String studentId);
	public boolean getPaymentStatus(String studentId);
	public List<Course> viewRegisteredCourses(String studentId);
	public List<Course> viewCourses(String studentId);
	public List<Grade> viewGradeCard(String studentId);
	public double calculateFee(String studentId);
	public boolean dropCourse(String courseCode, String studentId, List<Course> registeredCourseList);
	public boolean isReportGenerated(String studentId) ;
	public void setPaymentStatus(String studentId);
}
