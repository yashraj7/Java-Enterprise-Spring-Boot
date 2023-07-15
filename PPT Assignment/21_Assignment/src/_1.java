class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

class Solution {
	private List<Integer> inorderList;

	public TreeNode convertToBST(TreeNode root) {
		if (root == null) {
			return null;
		}

		// Step 1: Perform inorder traversal to get sorted list
		inorderList = new ArrayList<>();
		inorderTraversal(root);

		// Step 2: Sort the list
		Collections.sort(inorderList);

		// Step 3: Replace node values with sorted list values
		inorderIndex = 0;
		convertToBSTHelper(root);

		return root;
	}

	private void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		inorderList.add(root.val);
		inorderTraversal(root.right);
	}

	private int inorderIndex;

	private void convertToBSTHelper(TreeNode root) {
		if (root == null) {
			return;
		}

		convertToBSTHelper(root.left);
		root.val = inorderList.get(inorderIndex++);
		convertToBSTHelper(root.right);
	}

	// Function to print the inorder traversal of a binary tree (for verification)
	private void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		// Create a sample binary tree
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);

		Solution solution = new Solution();
		System.out.println("Original tree:");
		solution.printInorder(root);

		// Convert the binary tree into a binary search tree
		solution.convertToBST(root);

		System.out.println("\nBST after conversion:");
		solution.printInorder(root);
	}
}
