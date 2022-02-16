package com.crs.lt.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.business.ProfessorInterface;
import com.crs.lt.business.ProfessorService;

public class ProfessorCRSApplication {

	ProfessorInterface professorInterface = new ProfessorService();
	public void createMenu(String profID) {
		Scanner in = new Scanner(System.in);
		
		int input;
		while (CRSApplication.verified) {
			System.out.println("-------Professor Menu-----------");
			System.out.println("--------------------------------");
			System.out.println("1. view Enrolled Students");
			System.out.println("2. add Grades");
			System.out.println("3. logout");
			
			input = in.nextInt();
			switch (input) {
			
			case 1:
				viewEnrolledStudents(profID);
				break;
			case 2:
				addGrade(profID);
				break;
			case 3:
				CRSApplication.verified = false;
				return;
			default:
				System.out.println("Please select appropriate option...");
			}
		}
		in.close();
	}

	private void addGrade(String profId) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String courseCode, grade, studentId;
		
			List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
			enrolledStudents = professorInterface.viewEnrolledStudents(profId);
			System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for (EnrolledStudent obj: enrolledStudents) {
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			List<Course> coursesEnrolled = new ArrayList<Course>();
			coursesEnrolled	= professorInterface.viewCourses(profId);
			System.out.println("----------------Add Grade--------------");
			System.out.printf("Enter student id: ");
			studentId = in.nextLine();
			System.out.printf("Enter course code: ");
			courseCode = in.nextLine();
			System.out.println("Enter grade: ");
			grade = in.nextLine();
			professorInterface.addGrade(studentId, courseCode, grade);
			System.out.println("GradeConstant added successfully for "+studentId);
		
		
	}

	

	private void viewEnrolledStudents(String profID) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student" ));
		List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
		enrolledStudents = professorInterface.viewEnrolledStudents(profID);
		for (EnrolledStudent obj: enrolledStudents) {
			System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
		}
		
	}

//	private void getCourses(String profID) {
//		// TODO Auto-generated method stub
//		
//	}
}
