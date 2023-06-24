import java.util.PriorityQueue;

public class _1 {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		// Add the head nodes of all lists to the minHeap
		for (ListNode list : lists) {
			if (list != null) {
				minHeap.offer(list);
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		// Merge the lists by repeatedly taking the smallest node from the minHeap
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			current.next = node;
			current = current.next;

			if (node.next != null) {
				minHeap.offer(node.next);
			}
		}

		return dummy.next;
	}

	// Definition for singly-linked list
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		_1 solution = new _1();

		// Example lists
		ListNode list1 = solution.new ListNode(1);
		list1.next = solution.new ListNode(4);
		list1.next.next = solution.new ListNode(5);

		ListNode list2 = solution.new ListNode(1);
		list2.next = solution.new ListNode(3);
		list2.next.next = solution.new ListNode(4);

		ListNode list3 = solution.new ListNode(2);
		list3.next = solution.new ListNode(6);

		ListNode[] lists = { list1, list2, list3 };

		ListNode mergedList = solution.mergeKLists(lists);

		// Print the merged list
		while (mergedList != null) {
			System.out.print(mergedList.val + " ");
			mergedList = mergedList.next;
		}
		// Output: 1 1 2 3 4 4 5 6
	}
}
