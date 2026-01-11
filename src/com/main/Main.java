package com.main;

import java.util.Scanner;

import com.deoimplementation.UserImplementation;

import com.variables.User;

public class Main {

	public static void main(String[] args) {
		int num=0;
		boolean end=false;
		Scanner scanner = new Scanner(System.in);
		UserImplementation userimp= new UserImplementation();
		
		System.out.println("Select 1 option for User Registration");
		System.out.println("Select 2 option for User Login");
		System.out.println("Select 7 option for Guestmode");
		
		while(!end) {
			
		System.out.print("Enter your choice->");
		int choice=0;
		 choice = scanner.nextInt();
		
		switch (choice) {
	
		case 1:
			System.out.println("Enter the first name->");
			String firstName = scanner.next();
			System.out.println("Enter the last name->");
			String lastName = scanner.next();
			System.out.println("Enter the username->");
			String userName = scanner.next();
			System.out.println("Enter the password->");
			String password = scanner.next();
			System.out.println("Enter the city->");
			String city = scanner.next();
			System.out.println("Enter the mail id->");
			String mailId = scanner.next();
			System.out.println("Enter the mobile number->");
			long mobileNumber = scanner.nextLong();
			
			User user=new User();
			user.first_name=firstName;
			user.last_name=lastName;
			user.user_name=userName;
			user.password=password;
			user.city=city;
			user.mail_id=mailId;
			user.mobile_number=mobileNumber;			
			userimp.case1(user);
		    break;
			
		case 2:
			System.out.println("Enter the username->");
			String userName1 = scanner.next();
			System.out.println("Enter the password->");
			String password2 = scanner.next();
		   int number=1;
			num=UserImplementation.case2(userName1,password2,number);
			
			//System.out.println("Enter your choice->");
			//choice = scanner.nextInt();
		    break;
			
		case 3:
			if(num==1) {
			UserImplementation.case3();
			}else{
			System.out.println("login is necessary");
			}			
			break;
		
		case 4:
			if(num==1) {
			System.out.println("Enter the Product id->");
			int productId = scanner.nextInt();
			System.out.println("Enter the Quantity ->");
			int quantity = scanner.nextInt();
			String userName2=" ";
			UserImplementation.case4(productId,quantity,userName2);
			}else{
				System.out.println("login is necessary");
				}	
			
		    break;
			
		case 5:
			if(num==1) {
			System.out.println("Do you want to view cart (Yes/No) >");
			String input = scanner.next();
			UserImplementation.case5(input);
			}else{
				System.out.println("login is necessary");
				}	
			break;
		
		case 6:	
			if(num==1) {
			System.out.println("Enter the username->");
			String userName3 = scanner.next();
			System.out.println("Enter the Product id->");
			int productId1 = scanner.nextInt();
			 userimp.case6(userName3,productId1);
			}else{
				System.out.println("login is necessary");
				}	
			break;
			
		case 7:
			UserImplementation.case3();
			end=true;
		    break;
		
		
	
		}
		}
		
	}

}
