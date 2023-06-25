package MockTest3;

public class _1StackImpl {

	int capacity;
	int[] a;
	int top;
	int cnt;// count no of elements in stack

	_1StackImpl(int capacity) {
		this.capacity = capacity;
		a = new int[capacity];
	}

	public String push(int k) {
		if (top >= capacity)
			return "Stack Overflow";
		a[top++] = k;
		cnt++;
		return "Successfully Pushed" + k;
	}

	public String pop() {
		if (top < 0)
			return "Stack underflow";
		top--;
		cnt--;
		return "Popped:" + a[top];
	}

	public void display() {
		if (top >= 0) {
			for (int i = 0; i < top; i++)
				System.out.println(a[i]);

		}
	}

	public int peek() {
		if (top >= 0)
			return a[top];
		return -1;
	}

	public boolean isEmpty() {
		if (top < 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		_1StackImpl s = new _1StackImpl(10);
		s.push(1);
		s.push(2);
		s.push(5);
		s.push(3);
		s.push(4);
		s.display();

		System.out.println(s.pop());
		System.out.println(s.pop());

		System.out.println(s.pop());
		s.display();
		System.out.println(s.isEmpty());
		System.out.println(s.cnt);

	}

}
