
public class _8RainWaterStore {
	public int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}

		int n = height.length;
		int left = 0;
		int right = n - 1;
		int leftMax = height[left];
		int rightMax = height[right];
		int water = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					water += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					water += rightMax - height[right];
				}
				right--;
			}
		}

		return water;
	}
}
