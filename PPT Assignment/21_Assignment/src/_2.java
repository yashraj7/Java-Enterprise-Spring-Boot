class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

class Solution {
	public int findDistance(TreeNode root, int p, int q) {
		TreeNode lcaNode = findLCA(root, p, q);

		int distanceP = findDistanceFromNode(lcaNode, p, 0);
		int distanceQ = findDistanceFromNode(lcaNode, q, 0);

		return distanceP + distanceQ;
	}

	private TreeNode findLCA(TreeNode root, int p, int q) {
		if (root == null || root.val == p || root.val == q) {
			return root;
		}

		if (p < root.val && q < root.val) {
			return findLCA(root.left, p, q);
		} else if (p > root.val && q > root.val) {
			return findLCA(root.right, p, q);
		} else {
			return root;
		}
	}

	private int findDistanceFromNode(TreeNode node, int target, int distance) {
		if (node == null) {
			return -1;
		}

		if (node.val == target) {
			return distance;
		}

		int leftDistance = findDistanceFromNode(node.left, target, distance + 1);
		if (leftDistance != -1) {
			return leftDistance;
		}

		int rightDistance = findDistanceFromNode(node.right, target, distance + 1);
		if (rightDistance != -1) {
			return rightDistance;
		}

		return -1;
	}

	public static void main(String[] args) {
		// Create a sample Binary Search Tree
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		Solution solution = new Solution();

		int distance = solution.findDistance(root, 2, 6);
		System.out.println("Distance between nodes 2 and 6: " + distance);
	}
}
