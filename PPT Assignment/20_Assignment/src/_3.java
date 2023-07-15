import java.util.Stack;

class Solution {
	public static boolean isLevelOrderBST(int[] levelOrder) {
		if (levelOrder == null || levelOrder.length == 0) {
			return true;
		}

		int n = levelOrder.length;
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (levelOrder[i] < root || levelOrder[i] > max) {
				return false;
			}

			while (!stack.isEmpty() && levelOrder[i] > stack.peek()) {
				root = stack.pop();
			}

			stack.push(levelOrder[i]);

			if (levelOrder[i] < root) {
				max = root;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] levelOrder1 = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		int[] levelOrder2 = { 7, 4, 12, 3, 6, 8, 1, 5, 13 };

		boolean result1 = isLevelOrderBST(levelOrder1);
		boolean result2 = isLevelOrderBST(levelOrder2);

		System.out.println("Is level order traversal a BST? " + result1); // true
		System.out.println("Is level order traversal a BST? " + result2); // false
	}
}
