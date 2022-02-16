package com.crs.lt.business;

import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;

public interface ProfessorInterface {

	public boolean addGrade(String studentID, String courseID, String grade);
	public List<Course> viewCourses(String profID);
	String getProfessorById(String profId);
	public List<EnrolledStudent> viewEnrolledStudents(String profId);
}
