
public class _3MaxStudentsServed {
	public static int maxStudentsServed(int[] preferences) {
		int count0 = 0;
		int count1 = 0;

		for (int preference : preferences) {
			if (preference == 0) {
				count0++;
			} else {
				count1++;
			}
		}

		return Math.min(count0, count1);
	}

	public static void main(String[] args) {
		int[] preferences = { 0, 1, 0, 1, 1 };
		int maxStudents = maxStudentsServed(preferences);
		System.out.println("Maximum number of students served: " + maxStudents);
	}
}
