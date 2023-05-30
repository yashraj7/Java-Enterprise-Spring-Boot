package in.code.finalAssignment;

import java.util.Scanner;

//public class negativeNumberException extends Exception {
//	public negativeNumberException(String msg) {
//		super(msg);
//	}
//}

class Sexception {
	public static void check(int num) throws negativeNumberException {

		if (num < 0) {
			throw new negativeNumberException("negative number caught");
		}
		System.out.println("no exception occured");
	}
}

public class _3Exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the integer number:");
		try {
			Sexception.check(sc.nextInt());
		} catch (negativeNumberException e) {
			e.printStackTrace();
		}
	}
}
