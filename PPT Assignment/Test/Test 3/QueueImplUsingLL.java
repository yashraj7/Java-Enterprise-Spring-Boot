package MockTest3;

import java.util.NoSuchElementException;

public class QueueImplUsingLL<T> {
	private Node<T> front; // Points to the front of the queue
	private Node<T> rear; // Points to the rear of the queue

	private static class Node<T> {
		private T data; // Data of the node
		private Node<T> next; // Reference to the next node

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// Constructor to initialize an empty queue
	public QueueImplUsingLL() {
		// TODO Auto-generated constructor stub
		front = null;
		rear = null;
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return front == null;
	}

	// Add an element to the rear of the queue
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	// Remove and return the element from the front of the queue
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		T data = front.data;
		front = front.next;
		if (front == null) {
			rear = null; // If the last element was dequeued, update rear to null
		}
		return data;
	}

	public static void main(String[] args) {
		QueueImplUsingLL<Integer> queue = new QueueImplUsingLL<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println(queue.dequeue()); // Output: 10
		System.out.println(queue.dequeue()); // Output: 20

		System.out.println(queue.isEmpty()); // Output: false

		queue.enqueue(40);
		System.out.println(queue.dequeue()); // Output: 30
		System.out.println(queue.dequeue()); // Output: 40

		System.out.println(queue.isEmpty()); // Output: true

	}
}
