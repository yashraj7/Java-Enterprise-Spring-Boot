import java.util.Arrays;
import java.util.Comparator;

public class _6FindMinArrowShot {

	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0; // No balloons to burst
		}

		Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // Sort balloons based on the end points

		int arrows = 1; // At least one arrow needed to burst the first balloon
		int end = points[0][1]; // End point of the first balloon

		for (int i = 1; i < points.length; i++) {
			int start = points[i][0]; // Start point of the current balloon

			if (start > end) {
				arrows++; // Need another arrow since current balloon doesn't overlap with the previous
							// one
				end = points[i][1]; // Update the end point to the end of the current balloon
			}
		}

		return arrows;
	}

	public static void main(String[] args) {
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }; // Example balloons

		int minArrows = findMinArrowShots(points);
		System.out.println(minArrows); // Output: 2
	}
}
