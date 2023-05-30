package in.code.finalAssignment;

import java.util.Scanner;

public class _7BinarySearch {

	public static void main(String[] args) {
		int[] numbers = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the target value: ");
		int target = scanner.nextInt();

		int index = binarySearch(numbers, target);

		if (index != -1) {
			System.out.println("Target value found at index " + index);
		} else {
			System.out.println("Target value not found");
		}
	}

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target)
				return mid; // Target value found

			else if (arr[mid] < target)
				left = mid + 1; // Target value may be in the right half
			else
				right = mid - 1; // Target value may be in the left half

		}

		return -1; // Target value not found
	}

}
