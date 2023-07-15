
class _1TreeNode {
	int val;
	_1TreeNode left;
	_1TreeNode right;

	_1TreeNode(int val) {
		this.val = val;
	}
}

class Result {
	int maxSum;
	int subtreeSum;

	Result(int maxSum, int subtreeSum) {
		this.maxSum = maxSum;
		this.subtreeSum = subtreeSum;
	}
}

class Solution {
	public _1TreeNode findSubtreeWithMaxSum(_1TreeNode root) {
		Result result = findMaxSum(root);
		return result.maxSum != Integer.MIN_VALUE ? root : null;
	}

	private Result findMaxSum(_1TreeNode node) {
		if (node == null) {
			return new Result(Integer.MIN_VALUE, 0);
		}

		Result leftResult = findMaxSum(node.left);
		Result rightResult = findMaxSum(node.right);

		int subtreeSum = node.val + leftResult.subtreeSum + rightResult.subtreeSum;
		int maxSum = Math.max(subtreeSum, Math.max(leftResult.maxSum, rightResult.maxSum));

		return new Result(maxSum, subtreeSum);
	}

	public static void main(String[] args) {
		// Create a binary tree
		_1TreeNode root = new _1TreeNode(1);
		root.left = new _1TreeNode(-2);
		root.right = new _1TreeNode(3);
		root.left.left = new _1TreeNode(4);
		root.left.right = new _1TreeNode(5);
		root.right.left = new _1TreeNode(-6);
		root.right.right = new _1TreeNode(2);

		Solution solution = new Solution();
		_1TreeNode result = solution.findSubtreeWithMaxSum(root);

		if (result != null) {
			System.out.println("Subtree with maximum sum found!");
		} else {
			System.out.println("No subtree found.");
		}
	}
}
