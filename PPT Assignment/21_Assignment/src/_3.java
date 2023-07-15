class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    TreeNode prev;
    TreeNode head;

    public TreeNode convertToDLL(TreeNode root) {
        if (root == null)
            return null;

        convertToDLL(root.left);

        if (prev == null)
            head = root;
        else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        convertToDLL(root.right);

        return head;
    }

    public void printDLL(TreeNode head) {
        TreeNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution solution = new Solution();
        TreeNode head = solution.convertToDLL(root);

        System.out.println("Doubly Linked List: ");
        solution.printDLL(head);
    }
}
