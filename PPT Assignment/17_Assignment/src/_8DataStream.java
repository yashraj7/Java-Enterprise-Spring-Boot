import java.util.LinkedList;
import java.util.Queue;

public class _8DataStream {

	private int value;
	private int k;
	private Queue<Integer> stream;

	public _8DataStream(int value, int k) {
		this.value = value;
		this.k = k;
		this.stream = new LinkedList<>();
	}

	public boolean consec(int num) {
		stream.offer(num);
		if (stream.size() < k) {
			return false;
		}
		if (stream.size() > k) {
			stream.poll();
		}
		for (int n : stream) {
			if (n != value) {
				return false;
			}
		}
		return true;
	}

}
