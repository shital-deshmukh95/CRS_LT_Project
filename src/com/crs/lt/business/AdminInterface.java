package com.crs.lt.business;

import java.util.List;

import com.crs.lt.bean.Catalog;
import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.bean.RegisteredCourse;
import com.crs.lt.bean.Student;

public interface AdminInterface {

	public List<Catalog> viewCourses();
	public void addProfessor(Professor professor);
	public void removeCourse(String coursecode, List<Catalog> courseList);
	public void addCourse(Catalog course, List<Catalog> courseList);
}
