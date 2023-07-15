import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class NodeDetails {
    Node node;
    int horizontalDistance;

    NodeDetails(Node n, int hd) {
        node = n;
        horizontalDistance = hd;
    }
}

class BinaryTreeBottomView {
    static void printBottomView(Node root) {
        if (root == null)
            return;

        // Map to store the horizontal distance and the corresponding nodes
        Map<Integer, Node> bottomViewMap = new TreeMap<>();

        // Queue to perform level order traversal
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(root, 0));

        while (!queue.isEmpty()) {
            NodeDetails current = queue.poll();
            Node currentNode = current.node;
            int horizontalDistance = current.horizontalDistance;

            // Update the map with the current node for the horizontal distance
            bottomViewMap.put(horizontalDistance, currentNode);

            if (currentNode.left != null)
                queue.add(new NodeDetails(currentNode.left, horizontalDistance - 1));

            if (currentNode.right != null)
                queue.add(new NodeDetails(currentNode.right, horizontalDistance + 1));
        }

        // Print the nodes in the bottom view
        for (Map.Entry<Integer, Node> entry : bottomViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        System.out.println("Bottom view of the binary tree:");
        printBottomView(root);
    }
}
