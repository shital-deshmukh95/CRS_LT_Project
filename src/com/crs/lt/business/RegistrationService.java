package com.crs.lt.business;

import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Grade;
import com.crs.lt.doa.RegistrationDaoOperation;
import com.crs.lt.doa.RegistrationDAOInterface;

public class RegistrationService implements RegistrationInterface {

	RegistrationDAOInterface registrationDAOInterface = new RegistrationDaoOperation();
	@Override
	public boolean addCourse(String courseCode, String studentId,
			List<Course> availableCourseList) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.addCourse(courseCode, studentId);
	}

	@Override
	public void setRegistrationStatus(String studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getRegistrationStatus(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.getRegistrationStatus(studentId);
	}

	@Override
	public boolean getPaymentStatus(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.getPaymentStatus(studentId);
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.viewRegisteredCourses(studentId);
	}

	@Override
	public List<Course> viewCourses(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.viewCourses(studentId);
	}

	@Override
	public List<Grade> viewGradeCard(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.viewGradeCard(studentId);
	}

	@Override
	public double calculateFee(String studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean dropCourse(String courseCode, String studentId,
			List<Course> registeredCourseList) {
		// TODO Auto-generated method stub
		
		return registrationDAOInterface.dropCourse(courseCode, studentId, registeredCourseList);
	}

	@Override
	public boolean isReportGenerated(String studentId) {
		// TODO Auto-generated method stub
		return registrationDAOInterface.isReportGenerated(studentId);
	}

	@Override
	public void setPaymentStatus(String studentId) {
		// TODO Auto-generated method stub
		
	}

	
}
