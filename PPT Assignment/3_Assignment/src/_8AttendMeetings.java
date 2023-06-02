import java.util.Arrays;
import java.util.Comparator;

public class _8AttendMeetings {

	public static boolean canAttendMeetings(int[][] intervals) {
		// Sort the intervals based on the start time
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		// Check for any overlapping intervals
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[i - 1][1]) {
				return false; // Overlapping intervals found
			}
		}

		return true; // No overlapping intervals found
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		boolean canAttendAllMeetings = canAttendMeetings(intervals);
		System.out.println("Output: " + canAttendAllMeetings);
	}

}
