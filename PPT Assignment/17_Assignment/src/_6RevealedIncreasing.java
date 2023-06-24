import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _6RevealedIncreasing {

	public int[] deckRevealedIncreasing(int[] deck) {
		int n = deck.length;
		Arrays.sort(deck); // Sort the deck in increasing order

		Deque<Integer> queue = new LinkedList<>();
		// Initialize the queue with indices from 0 to n-1
		for (int i = 0; i < n; i++) {
			queue.offer(i);
		}

		int[] result = new int[n];
		// Reveal the cards in increasing order
		for (int card : deck) {
			result[queue.poll()] = card; // Assign the next card to the revealed position
			if (!queue.isEmpty()) {
				queue.offer(queue.poll()); // Move the next card to the bottom of the deck
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
		_6RevealedIncreasing cardOrdering = new _6RevealedIncreasing();
		int[] ordering = cardOrdering.deckRevealedIncreasing(deck);
		System.out.println("Ordering: " + Arrays.toString(ordering));
	}
}
