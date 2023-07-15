class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

class Solution {
	public TreeNode constructBST(int[] levelOrder) {
		if (levelOrder == null || levelOrder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(levelOrder[0]);

		for (int i = 1; i < levelOrder.length; i++) {
			insertNode(root, levelOrder[i]);
		}

		return root;
	}

	private void insertNode(TreeNode node, int value) {
		if (value < node.val) {
			if (node.left == null) {
				node.left = new TreeNode(value);
			} else {
				insertNode(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new TreeNode(value);
			} else {
				insertNode(node.right, value);
			}
		}
	}

	public static void main(String[] args) {
		int[] levelOrder = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };

		Solution solution = new Solution();
		TreeNode root = solution.constructBST(levelOrder);

		// Test the constructed BST
		// Perform any required operations or validations on the BST
		// For example, you can perform inorder traversal to check if the BST is
		// constructed correctly

		System.out.println("BST constructed successfully.");
	}
}
