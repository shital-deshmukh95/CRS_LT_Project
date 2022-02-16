package com.crs.lt.doa;

import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;

public interface ProfessorDOAInterface {

	public List<Course> getCoursesByProfessor(String userId);
	public List<EnrolledStudent> getEnrolledStudents(String CourseId);
	public Boolean addGrade(String studentId,String courseCode,String grade);
	public String getProfessorById(String profId);
}
