class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreeFlip {
    Node root;

    Node flipBinaryTree(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        // Recursively flip the left and right subtrees
        Node flippedLeft = flipBinaryTree(node.left);
        Node flippedRight = flipBinaryTree(node.right);

        // Flip the current node
        node.left.left = node.right;
        node.left.right = node;
        node.left = node.right = null;

        return flippedLeft;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFlip tree = new BinaryTreeFlip();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Original Tree (Inorder traversal):");
        tree.printInorder(tree.root);

        Node flippedTree = tree.flipBinaryTree(tree.root);

        System.out.println("\nFlipped Tree (Inorder traversal):");
        tree.printInorder(flippedTree);
    }
}
