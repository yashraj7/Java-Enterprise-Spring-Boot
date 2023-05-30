package in.jdbcProject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.jdbcProject.dto.Student;
import in.jdbcProject.service.IStudentService;
import in.jdbcProject.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
//		insertOperation();
//		selectOperation();
//		deleteOperation();

//		updationOperation();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String st = br.readLine();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("5.Exit");
			System.out.println("Enter the Choice [1,2,3,4,5] :");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				insertOperation();
				break;
			case 2:
				selectOperation();
				break;
			case 3:
				updationOperation();
				break;
			case 4:
				deleteOperation();
				break;
			case 5:
				System.out.println("Thankyou For USING OUR APPLICATION.");
				System.exit(0);
				break;

			default:
				System.out.println("Enter invalid choice ENTER AGAIN:");
				break;
			}
		}

	}

	private static void updationOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Sid of the student to be updated:");
		int sid = sc.nextInt();

		Student std = studentService.searchStudent(sid);

		if (std != null) {
			Student newStudent = new Student();

			newStudent.setSid(sid);

			System.out.println("Old name " + std.getSname() + " Enter new Name :");
			String newName = sc.next();

			if (newName.equals("") || newName == "") {
				newStudent.setSname(std.getSname());
			} else {
				newStudent.setSname(newName);
			}

			System.out.println("Old age " + std.getSage() + " Enter new age:");
			String newAge = sc.next();

			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(std.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}

			System.out.println("Old addr " + std.getSaddress() + " Enter new Address :");
			String newAddr = sc.next();

			if (newAddr.equals("") || newAddr == "") {
				newStudent.setSage(std.getSage());
			} else {
				newStudent.setSaddress(newAddr);
			}

			String status = studentService.updateStudent(newStudent);

			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated successfully");
			} else {
				System.out.println("record updation failed");
			}
		} else
			System.out.println("Student not available for Given Id : " + sid + " for updation.");
	}

	private static void deleteOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Sid of the student:");
		int sid = sc.nextInt();
		String msg = studentService.deleteStudent(sid);

		if (msg.equalsIgnoreCase("success"))
			System.out.println("record deleted Successfully");
		else if (msg.equalsIgnoreCase("not found"))
			System.out.println("Record can't be deleted!!!!!!!!!!!Not Found");
		else
			System.out.println("Deletion Failed");
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

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name of the student:");
		String name = sc.next();

		System.out.println("Enter age of the student:");
		int age = sc.nextInt();

		System.out.println("Enter address of the student:");
		String address = sc.next();

		String msg = studentService.addStudent(name, age, address);

		if (msg.equalsIgnoreCase("success"))
			System.out.println("record inserted Successfully");
		else
			System.out.println("Record can't be inserted!!!!!!!!!!!");

	}

}
