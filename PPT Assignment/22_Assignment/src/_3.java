import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreePaths {
    Node root;

    void printRootToLeafPaths(Node root) {
        if (root == null) {
            return;
        }

        // Create stacks for nodes and paths
        Stack<Node> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();

        // Push the root node and its path
        nodeStack.push(root);
        pathStack.push(Integer.toString(root.data));

        while (!nodeStack.isEmpty()) {
            Node currentNode = nodeStack.pop();
            String currentPath = pathStack.pop();

            // If the current node is a leaf, print the path
            if (currentNode.left == null && currentNode.right == null) {
                System.out.println(currentPath);
            }

            // Push the left child node and update the path
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                pathStack.push(currentPath + "->" + currentNode.left.data);
            }

            // Push the right child node and update the path
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                pathStack.push(currentPath + "->" + currentNode.right.data);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Root-to-Leaf Paths:");
        tree.printRootToLeafPaths(tree.root);
    }
}
