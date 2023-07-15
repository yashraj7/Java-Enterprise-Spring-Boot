class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BinaryTreeToDLL {
	Node root;
	Node head; // Head of the DLL

	Node prev = null; // Pointer to the previously visited node

	void convertToDLL(Node node) {
		if (node == null)
			return;

		// Recursively convert the left subtree
		convertToDLL(node.left);

		// Process the current node
		if (prev == null) {
			// If prev is null, it means we are visiting the leftmost node
			head = node;
		} else {
			// Adjust the pointers for the current node
			node.left = prev;
			prev.right = node;
		}
		prev = node; // Update prev

		// Recursively convert the right subtree
		convertToDLL(node.right);
	}

	void printDLL(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.right;
		}
	}

	public static void main(String[] args) {
		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// Convert the binary tree to DLL
		tree.convertToDLL(tree.root);

		// Print the DLL
		System.out.println("Doubly Linked List (DLL):");
		tree.printDLL(tree.head);
	}
}
