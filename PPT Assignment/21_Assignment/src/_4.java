class Node {
    int val;
    Node left;
    Node right;
    Node nextRight;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    public void connectNodesAtSameLevel(Node root) {
        if (root == null)
            return;

        // Start with the root node
        Node levelStart = root;

        // Traverse each level of the tree
        while (levelStart != null) {
            Node curr = levelStart;
            Node dummy = new Node(0); // Dummy node for connecting the next right node
            Node prev = dummy;

            // Traverse the current level and connect the nodes
            while (curr != null) {
                if (curr.left != null) {
                    prev.nextRight = curr.left;
                    prev = prev.nextRight;
                }
                if (curr.right != null) {
                    prev.nextRight = curr.right;
                    prev = prev.nextRight;
                }
                curr = curr.nextRight;
            }

            // Move to the next level
            levelStart = dummy.nextRight;
        }
    }

    public void printNodesAtSameLevel(Node root) {
        Node currLevel = root;
        while (currLevel != null) {
            Node curr = currLevel;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.nextRight;
            }
            System.out.println();
            currLevel = currLevel.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Solution solution = new Solution();
        solution.connectNodesAtSameLevel(root);

        System.out.println("Nodes at the same level:");
        solution.printNodesAtSameLevel(root);
    }
}
