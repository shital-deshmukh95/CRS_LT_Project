package com.crs.lt.business;

import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.doa.ProfessorDOAInterface;
import com.crs.lt.doa.ProfessorDaoOperation;

public class ProfessorService implements ProfessorInterface{

	ProfessorDOAInterface professorDOAInterface = new ProfessorDaoOperation();
	@Override
	public boolean addGrade(String studentID, String courseID, String grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> viewCourses(String profID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProfessorById(String profId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(String profId) {
		// TODO Auto-generated method stub
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		return enrolledStudents=professorDOAInterface.getEnrolledStudents(profId);
	}

	
}
