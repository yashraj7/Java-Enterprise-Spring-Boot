package in.jdbcProject.controller;

import java.util.Scanner;

import in.jdbcProject.dto.Student;
import in.jdbcProject.service.IStudentService;
import in.jdbcProject.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Read");
			System.out.println("2.Exit");
			System.out.println("Enter the Choice [1,2] :");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				selectOperation();
				break;

			case 2:
				System.out.println("Thankyou For USING OUR APPLICATION.");
				System.exit(0);
				break;

			default:
				System.out.println("Enter invalid choice ENTER AGAIN:");
				break;
			}
		}

	}

	private static void selectOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Sid of the student:");
		int sid = sc.nextInt();
		Student std = studentService.searchStudent(sid);

		if (std != null) {
			System.out.println(std);
			System.out.println(std.getSid() + " " + std.getSname() + " " + std.getSage() + " " + std.getSaddress());
		} else
			System.out.println("No such record Exist");
	}

}
