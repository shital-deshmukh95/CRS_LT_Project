package com.crs.lt.business;

import java.util.List;

import com.crs.lt.bean.Catalog;
import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.bean.RegisteredCourse;
import com.crs.lt.bean.Student;
import com.crs.lt.doa.AdminDOAInterface;
import com.crs.lt.doa.AdminDoaOperation;

public class AdminService implements AdminInterface {

	AdminDOAInterface adminDOAInterface = new AdminDoaOperation();
	@Override
	public List<Catalog> viewCourses() {
		// TODO Auto-generated method stub
		return adminDOAInterface.viewCourses(); 
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void removeCourse(String coursecode, List<Catalog> courseList) {
		// TODO Auto-generated method stub
		adminDOAInterface.removeCourse(coursecode);
		
	}

	@Override
	public void addCourse(Catalog course, List<Catalog> courseList) {
		// TODO Auto-generated method stub
		adminDOAInterface.addCourse(course);
	}
	
	
}
