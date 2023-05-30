package in.code.finalAssignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class _9ProducerConsumer {
	public static void main(String[] args) {
		// Create a shared queue
		Queue<Integer> queue = new LinkedList<>();

		// Create a producer thread
		Thread producerThread = new Thread(new Producer(queue));
		// Create a consumer thread
		Thread consumerThread = new Thread(new Consumer(queue));

		// Start the threads
		producerThread.start();
		consumerThread.start();
	}
}

class Producer implements Runnable {
	private final Queue<Integer> queue;
	private final int MAX_SIZE = 10;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();

		while (true) {
			synchronized (queue) {
				// Wait if the queue is full
				while (queue.size() == MAX_SIZE) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Generate a random number
				int number = random.nextInt(100);
				System.out.println("Produced: " + number);

				// Add the number to the queue
				queue.add(number);

				// Notify the consumer thread
				queue.notifyAll();
			}

			// Introduce a delay
			try {
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private final Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				// Wait if the queue is empty
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Remove the number from the queue
				int number = queue.poll();
				System.out.println("Consumed: " + number);

				// Notify the producer thread
				queue.notifyAll();
			}

			// Calculate the sum of consumed numbers
			calculateSum();
		}
	}

	private void calculateSum() {
		synchronized (queue) {
			int sum = 0;
			for (int number : queue) {
				sum += number;
			}
			System.out.println("Sum: " + sum);
		}
	}
}
