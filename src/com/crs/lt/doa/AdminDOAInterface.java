package com.crs.lt.doa;

import java.util.List;

import com.crs.lt.bean.Catalog;
import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;

public interface AdminDOAInterface {
	/**
	 * @return
	 */
	public List<Catalog> viewCourses();
	public void addProfessor(Professor professor);
	public void removeCourse(String coursecode);
	public void addCourse(Catalog course);
	
	
}
