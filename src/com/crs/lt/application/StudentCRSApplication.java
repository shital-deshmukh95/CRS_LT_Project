package com.crs.lt.application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Grade;
import com.crs.lt.business.NotificationInterface;
import com.crs.lt.business.NotificationService;
import com.crs.lt.business.RegistrationInterface;
import com.crs.lt.business.RegistrationService;

public class StudentCRSApplication {
	
	Boolean is_registered;
	RegistrationInterface registrationInterface = new RegistrationService();
	NotificationInterface notificationInterface = new NotificationService();
	Scanner sc = new Scanner(System.in);
	public void studentMenu(String studentId){
		while(CRSApplication.verified){
			System.out.println("**********Student Menu*********");
			System.out.println("1. Course Registration");
			System.out.println("2. Add Course for Student");
			System.out.println("3. Drop Course for Student");
			System.out.println("4. View Available Course List");
			System.out.println("5. View Registered Courses");
			System.out.println("6. View grade card");
			System.out.println("7. Make Payment");
			System.out.println("8. Logout");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			
			case 1: 
				registerCourses(studentId);
				break;
				
			case 2:
				addCourse(studentId);
				break;
				
			case 3:
				dropCourse(studentId);
				break;
				
			case 4:
				viewCourse(studentId);
				break;
				
			case 5:
				viewRegisteredCourse(studentId);
				break;
				
			case 6:
				viewGradeCard(studentId);
				break;
				
			case 7:
				makePayment(studentId);
				break;
				
			case 8:
				CRSApplication.verified = false;
				break;			
				
			default:
				System.out.println("Enter a valid choice");

		
		}
	}
		}
		
	private void makePayment(String studentId) {
		// TODO Auto-generated method stub
		double fee = 12000;
		boolean isRegistered = false;
		boolean isPaid = false;
		
		isRegistered = registrationInterface.getRegistrationStatus(studentId);
		isPaid = registrationInterface.getPaymentStatus(studentId);
		if(!isRegistered)
		{
			System.out.println("You have not registered yet");
		}
		else if(isRegistered && !isPaid)
		{
			
			System.out.println("Your total fee  = " + fee);
			notificationInterface.sendNotification();
			System.out.println("Payment Successful by StudentId :" + studentId);
		}
		
	}
	private void viewGradeCard(String studentId) {
		// TODO Auto-generated method stub
		List<Grade> gradeCard=null;
		boolean isReportGenerated = false;
		isReportGenerated = registrationInterface.isReportGenerated(studentId);
		if(isReportGenerated) {
			gradeCard = registrationInterface.viewGradeCard(studentId);
			
			if(gradeCard.isEmpty())
			{
				System.out.println("You haven't registered for any course");
				return;
			}
			
			for(Grade grade : gradeCard)
			{
				System.out.println("Grade Card for Student: " + studentId);
				System.out.println("Course Name: " + grade.getCourseName());
				System.out.println("Course Code: " + grade.getCourseCode());
				System.out.println("Grade: " + grade.getGrade());
			}
		}
		else
			System.out.println("No report generated");
	}
	private List<Course> viewRegisteredCourse(String studentId) {
		// TODO Auto-generated method stub
		List<Course> course_registered = null;
		course_registered = registrationInterface
				.viewRegisteredCourses(studentId);

		if (course_registered.isEmpty()) {
			System.out.println("No course registered");
			return course_registered;
		}

		for (Course c : course_registered) {
			System.out.println("Course Code: " + c.getCourseCode()
					+ "Course Name: " + c.getCourseName() + "Instructor ID: "
					+ c.getInstructorId() + "Available Seats: "
					+ c.getAvailable_seats());
		}

		return course_registered;

	}
	private List<Course> viewCourse(String studentId) {
		List <Course> courseList = null;
		courseList = registrationInterface.viewCourses(studentId);
		if (!courseList.isEmpty()){
			for (Course c : courseList){
				System.out.println("Course Code: " + c.getCourseCode()
						+ "Course Name: " + c.getCourseName()
						+ "Instructor ID: " + c.getInstructorId()
						+ "Available Seats: " + c.getAvailable_seats());

			}
		}
		else{
			System.out.println("No courses available currently");
		}
			
		
		return courseList;
		
	}
	private void dropCourse(String studentId) {
		// TODO Auto-generated method stub
		List<Course> registeredCourseList=viewRegisteredCourse(studentId);
		if(registeredCourseList==null)
			return;
		
		System.out.println("Enter the Course Code : ");
		String courseCode = sc.next();
		boolean isDropped = registrationInterface.dropCourse(courseCode, studentId,registeredCourseList);
		if(isDropped){
			System.out.println("You have successfully dropped Course : " + courseCode);
		}
		else 
			System.out.println("Failed tp drop the course");
		
		
	}
	private void addCourse(String studentId) {
		// TODO Auto-generated method stub
		List<Course> availableCourseList=viewCourse(studentId);
		System.out.println("Enter Course Code : " );
		String courseCode = sc.next();
		if(registrationInterface.addCourse(courseCode, studentId,availableCourseList))
		{
			System.out.println(" You have successfully registered for Course : " + courseCode);
		}
		else
		{
			System.out.println(" You have already registered for Course : " + courseCode);
		}
		
	}
	private void registerCourses(String studentId) {
		// TODO Auto-generated method stub
		int count = 0;
		
			try
			{
				List<Course> courseList=viewCourse(studentId);
				
				if(courseList==null)
					return;
				
				System.out.println("Enter Course Code : " + (count+1));
				String courseCode = sc.next();
				
				if(registrationInterface.addCourse(courseCode,studentId,courseList))
				{
					System.out.println("Course " + courseCode + " registered sucessfully.");
					count++;
				}
				else
				{
					System.out.println(" You have already registered for Course : " + courseCode);
				}
			}	
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("\n*******************************************************");
		System.out.println("Registration Successful");
		System.out.println("*******************************************************\n");
		
		registrationInterface.setRegistrationStatus(studentId);
	    is_registered = true;
	    
		
	}
	private boolean getRegistrationStatus(String studentId){
		return registrationInterface.getRegistrationStatus(studentId) ;
		
	}
}
