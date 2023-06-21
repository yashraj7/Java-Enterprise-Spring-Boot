import java.util.LinkedList;
import java.util.Queue;

public class _3ImplementStack {

	    private Queue<Integer> q1;
	    private Queue<Integer> q2;

		public _3ImplementStack() {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	    }

	    public void push(int x) {
	        q2.add(x);
	        while (!q1.isEmpty()) {
	            q2.add(q1.poll());
	        }
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	    }

	    public int pop() {
	        if (q1.isEmpty()) {
	            throw new IllegalStateException("Stack is empty");
	        }
	        return q1.poll();
	    }

	    public int top() {
	        if (q1.isEmpty()) {
	            throw new IllegalStateException("Stack is empty");
	        }
	        return q1.peek();
	    }

	    public boolean isEmpty() {
	        return q1.isEmpty();
	    }

	    public int size() {
	        return q1.size();
	    }

	    public static void main(String[] args) {
	        _3ImplementStack stack = new _3ImplementStack();
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);

	        System.out.println("Stack size: " + stack.size());
	        System.out.println("Top element: " + stack.top());

	        System.out.println("Popped element: " + stack.pop());
	        System.out.println("Popped element: " + stack.pop());

	        System.out.println("Is stack empty? " + stack.isEmpty());
	    }
	}
