package com.crs.lt.application;

import java.util.Scanner;

import com.crs.lt.business.UserInterface;
import com.crs.lt.business.UserService;


public class CRSApplication {

	/**
	 * @param args
	 */
	static boolean verified = false;
	UserInterface userInterface = new UserService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRSApplication crs = new CRSApplication();
		
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		crsMenu();
		x = scanner.nextInt();
		try {
			while(x!=4)
			{
				switch(x){
				case 1:
					crs.loginUser();
					break;
				case 2:
					crs.RegisterStudent();
					break;
				case 3:
					crs.updatePassword();
					break;
				default:
					System.out.println("The session ended");
				}
				//crsMenu();
				//x = scanner.nextInt();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured");
			e.printStackTrace();
		}
		finally{
			scanner.close();
		}
		
	}
	

	public static void crsMenu() {
		System.out.println("Welcome to the CRS Application");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
	}
	public void updatePassword() {
		// TODO Auto-generated method stub
		
	}

	public void RegisterStudent() {
		// TODO Auto-generated method stub
		
	}

	public void loginUser() {
		// TODO Auto-generated method stub
		Scanner user = new Scanner(System.in);
		String userId, password;
		System.out.println("---Login To CRS-------");
		System.out.println("UserId:");
		userId = user.next();
		System.out.println("Password:");
		password = user.next();
		//Verify Cerds of user
		
		verified = userInterface.verifyCredentials(userId, password);
		System.out.println("User is verified" + verified);
		
		if(verified){
			String role = userInterface.getRole(userId);
			
			switch(role){
			case "STUDENT":
				System.out.println("The role of user is Student");
				StudentCRSApplication studentCRSApplication = new StudentCRSApplication();
				studentCRSApplication.studentMenu(userId);
				break;
			case "PROFESSOR":
				System.out.println("The role of user is Professor");
				ProfessorCRSApplication professorCRSApplication = new ProfessorCRSApplication();
				professorCRSApplication.createMenu(userId);
				break;
			case "ADMIN":
				System.out.println("The role of user is Admin");
				AdminCRSApplication adminCRSApplication = new AdminCRSApplication();
				adminCRSApplication.createMenu();
				break;
			}
		}
		else
			System.out.println("Kindly check the userId and password");
	}

}
