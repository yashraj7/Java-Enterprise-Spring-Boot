import java.util.ArrayDeque;
import java.util.Deque;

public class _7FrontMiddleBackQueue {

	private Deque<Integer> frontDeque;
	private Deque<Integer> backDeque;

	public _7FrontMiddleBackQueue() {
		frontDeque = new ArrayDeque<>();
		backDeque = new ArrayDeque<>();
	}

	public void pushFront(int val) {
		frontDeque.offerFirst(val);
		balance();
	}

	public void pushMiddle(int val) {
		if (frontDeque.size() > backDeque.size()) {
			backDeque.offerFirst(frontDeque.pollLast());
		}
		frontDeque.offerLast(val);
	}

	public void pushBack(int val) {
		backDeque.offerLast(val);
		balance();
	}

	public int popFront() {
		if (isEmpty()) {
			return -1;
		}
		if (frontDeque.isEmpty()) {
			int val = backDeque.pollFirst();
			balance();
			return val;
		}
		return frontDeque.pollFirst();
	}

	public int popMiddle() {
		if (isEmpty()) {
			return -1;
		}
		if (frontDeque.size() > backDeque.size()) {
			return frontDeque.pollLast();
		}
		return backDeque.pollFirst();
	}

	public int popBack() {
		if (isEmpty()) {
			return -1;
		}
		if (backDeque.isEmpty()) {
			int val = frontDeque.pollLast();
			balance();
			return val;
		}
		return backDeque.pollLast();
	}

	private void balance() {
		while (frontDeque.size() > backDeque.size() + 1) {
			backDeque.offerFirst(frontDeque.pollLast());
		}
		while (frontDeque.size() < backDeque.size()) {
			frontDeque.offerLast(backDeque.pollFirst());
		}
	}

	private boolean isEmpty() {
		return frontDeque.isEmpty() && backDeque.isEmpty();
	}

	public static void main(String[] args) {
		_7FrontMiddleBackQueue queue = new _7FrontMiddleBackQueue();

		queue.pushFront(1);
		queue.pushBack(2);
		queue.pushMiddle(3);
		queue.pushFront(4);

		System.out.println(queue.popFront()); // Output: 4
		System.out.println(queue.popMiddle()); // Output: 3
		System.out.println(queue.popBack()); // Output: 2
		System.out.println(queue.popFront()); // Output: 1
		System.out.println(queue.popFront()); // Output: -1 (empty queue)
	}
}
