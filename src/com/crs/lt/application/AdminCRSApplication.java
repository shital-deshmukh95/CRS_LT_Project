package com.crs.lt.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.crs.lt.bean.Catalog;
import com.crs.lt.bean.Course;
import com.crs.lt.business.AdminInterface;
import com.crs.lt.business.AdminService;
import com.crs.lt.business.NotificationInterface;
import com.crs.lt.business.NotificationService;
import com.crs.lt.business.RegistrationInterface;
import com.crs.lt.business.RegistrationService;

public class AdminCRSApplication {
	RegistrationInterface registrationInterface = new RegistrationService();
	NotificationInterface notificationInterface = new NotificationService();
	AdminInterface adminInterface = new AdminService();
	Scanner in = new Scanner(System.in);
	public void createMenu(){
		while(CRSApplication.verified) {
			System.out.println("*****************************");
			System.out.println("**********Admin Menu*********");
			System.out.println("*****************************");
			System.out.println("1. View course");
			System.out.println("2. Add Course to catalog");
			System.out.println("3. Delete Course from catalog");
			System.out.println("4. Logout");
			System.out.println("*****************************");
			
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				viewCourses();
				break;
				
			case 2:
				addCourse();
				break;
				
			case 3:
				removeCourse();
				break;
			
			case 4:
				CRSApplication.verified = false;
				return;

			default:
				System.out.println("***** Wrong Choice *****");
			}
		}

	}

	private void removeCourse() {
		// TODO Auto-generated method stub
		List<Catalog> courseList = viewCourses();
		System.out.println("Enter Course Code:");
		String courseCode = in.next();

			adminInterface.removeCourse(courseCode, courseList);
			System.out.println("\nCourse Deleted : "+courseCode+"\n");
	}
	private void addCourse() {
		List<Catalog> courseList = viewCourses();

		in.nextLine();
		System.out.println("Enter Course Code:");
		String courseCode = in.nextLine();
		
		System.out.println("Enter Course Name:");
		String courseName = in.next();
		System.out.println("Enter decription of course");
		String description = in.next();
		
		
		Catalog course = new Catalog(courseCode, courseName, description);
		course.setCourseCode(courseCode);
		course.setCourseName(courseName);
		
		
		try {
		adminInterface.addCourse(course, courseList);		
		}
		catch (Exception e) {
			System.out.println("Course already existed "+e.getMessage());
		}
		
	}
	private List<Catalog> viewCourses() {
		List<Catalog> courseList = adminInterface.viewCourses();
		if(courseList.size() == 0) {
			System.out.println("Nothing present in the catalogue!");
			return courseList;
		}
		System.out.println(String.format("%10s | %10s | %10s","COURSE CODE", "COURSE NAME", "INSTRUCTOR ID"));
		for(Catalog course : courseList) {
			System.out.println(String.format("%10s | %10s | %10s", course.getCourseCode(), course.getCourseName(), course.getDescription()));
		}
		return courseList;
	}
	}
