package in.code.finalAssignment;

public class _8Threads {
	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++)
				if (i % 2 == 0)
					System.out.print(i + " ");
			System.out.println();
		});
		Thread th2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++)
				if (i % 2 != 0)
					System.out.print(i + " ");
		});
		th1.start();
		th1.join();
		th2.start();
	}

}
