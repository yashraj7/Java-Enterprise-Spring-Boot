
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class _4ConstructBinaryTreeFromString {
	public static TreeNode str2tree(String s) {
		if (s.isEmpty()) {
			return null;
		}

		int firstParen = s.indexOf("(");
		int val = (firstParen == -1) ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
		TreeNode root = new TreeNode(val);

		if (firstParen == -1) {
			return root;
		}

		int start = firstParen, openParenCount = 0;
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				openParenCount++;
			} else if (s.charAt(i) == ')') {
				openParenCount--;
			}

			if (openParenCount == 0 && start == firstParen) {
				root.left = str2tree(s.substring(start + 1, i));
				start = i + 1;
			} else if (openParenCount == 0) {
				root.right = str2tree(s.substring(start + 1, i));
			}
		}

		return root;
	}

	public static void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		TreeNode root = str2tree(s);
		printInorder(root); // Output: 3 2 1 4 5 6
	}
}
