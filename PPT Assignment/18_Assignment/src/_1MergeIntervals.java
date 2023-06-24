import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1MergeIntervals {
	public static int[][] merge(int[][] a) {
		// Edge Case
		if (a == null || a.length == 0)
			return a;

		Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
		List<int[]> ans = new ArrayList<>();
		int start = a[0][0];
		int end = a[0][1];
		for (int[] i : a) {
			if (i[0] <= end)
				end = Math.max(i[1], end);
			else {
				ans.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			}
		}
		ans.add(new int[] { start, end });
		return ans.toArray(new int[0][]);
	}
}
