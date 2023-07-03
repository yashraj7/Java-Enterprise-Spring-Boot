package demo;

import java.util.List;

public class _3FindAvg {

	public static void main(String[] args) {
		List<Integer> lt = List.of(10, 30, 40, 69, 40);
		int i = 0;
		int sum = 0;
		do {
			sum += lt.get(i++);
		} while (i < lt.size());
		double avg = (sum / (double) lt.size());
		System.out.println(avg);
	}
}
