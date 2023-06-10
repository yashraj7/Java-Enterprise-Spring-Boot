
public class _6TOH {
	public static void solveTowerOfHanoi(int n, String source, String auxiliary, String destination) {
		if (n == 1) {
			System.out.println("Move disk 1 from " + source + " to " + destination);
			return;
		}

		solveTowerOfHanoi(n - 1, source, destination, auxiliary);

		System.out.println("Move disk " + n + " from " + source + " to " + destination);

		solveTowerOfHanoi(n - 1, auxiliary, source, destination);
	}

	public static void main(String[] args) {
		int n = 3;
		String sourceRod = "Rod 1";
		String auxiliaryRod = "Rod 2";
		String destinationRod = "Rod 3";

		System.out.println("Tower of Hanoi solution for " + n + " disks:");
		solveTowerOfHanoi(n, sourceRod, auxiliaryRod, destinationRod);
	}
}
