package com.crs.lt.business;

import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Grade;

public interface RegistrationInterface {
	public boolean addCourse(String courseCode, String studentId, List<Course> availableCourseList);
	void setRegistrationStatus(String studentId);
	boolean getRegistrationStatus(String studentId);
	boolean getPaymentStatus(String studentId);
	List<Course> viewRegisteredCourses(String studentId);
	List<Course> viewCourses(String studentId);
	List<Grade> viewGradeCard(String studentId);
	double calculateFee(String studentId);
	boolean dropCourse(String courseCode, String studentId, List<Course> registeredCourseList);
	public boolean isReportGenerated(String studentId) ;
	public void setPaymentStatus(String studentId);
	
}
