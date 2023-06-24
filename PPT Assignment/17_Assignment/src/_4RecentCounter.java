import java.util.LinkedList;
import java.util.Queue;

public class _4RecentCounter {
	private Queue<Integer> requests;

	public _4RecentCounter() {
		requests = new LinkedList<>();
	}

	public int ping(int t) {
		// Add the current request to the queue
		requests.offer(t);

		// Remove requests that are outside the time frame
		while (t - requests.peek() > 3000) {
			requests.poll();
		}

		// Return the number of recent requests within the time frame
		return requests.size();
	}

	public static void main(String[] args) {
		_4RecentCounter counter = new _4RecentCounter();
		System.out.println(counter.ping(100)); // Output: 1
		System.out.println(counter.ping(300)); // Output: 2
		System.out.println(counter.ping(900)); // Output: 3
		System.out.println(counter.ping(1500)); // Output: 4
		System.out.println(counter.ping(3000)); // Output: 5
		System.out.println(counter.ping(3001)); // Output: 3
	}
}
