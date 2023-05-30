package in.code.finalAssignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _6Streams {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++)
			al.add(i);
		List<Integer> evenNo = al.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers:" + evenNo);
		List<Integer> reverseNo = evenNo.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorted Numbers" + reverseNo);

	}
}
