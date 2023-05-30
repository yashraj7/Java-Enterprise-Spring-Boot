package in.code.finalAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10SecondLargestElement {
	public static void main(String[] args) {
		List<Integer> numbers = readIntegers();

		int secondLargest = findSecondLargest(numbers);
		int secondSmallest = findSecondSmallest(numbers);

		System.out.println("Second largest element: " + secondLargest);
		System.out.println("Second smallest element: " + secondSmallest);
	}

	public static List<Integer> readIntegers() {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<>();

		System.out.print("Enter the number of integers: ");
		int count = scanner.nextInt();

		System.out.println("Enter the integers:");
		for (int i = 0; i < count; i++) {
			int num = scanner.nextInt();
			numbers.add(num);
		}

		return numbers;
	}

	public static int findSecondLargest(List<Integer> numbers) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int num : numbers) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num < largest) {
				secondLargest = num;
			}
		}

		return secondLargest;
	}

	public static int findSecondSmallest(List<Integer> lt) {
		int secondSmallest = Integer.MAX_VALUE;
		int smallest = Integer.MAX_VALUE;
		for (Integer num : lt) {
			if (num < smallest) {
				secondSmallest = smallest;
				smallest = num;
			} else if (num < secondSmallest && num > smallest)
				secondSmallest = num;
		}
		return secondSmallest;

	}
}
