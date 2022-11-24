import java.util.*;

class Guesser {
	int guessNum;

	int guessNum(int n) {

		Scanner scan = new Scanner(System.in);
		int i = -2;
		while (i == -2) {
			i = 1;
			System.out.println("Guesser kindly guess the number between 1 to " + n);
			guessNum = scan.nextInt();
			if (guessNum < 1 || guessNum > n) {
				System.out.println("Invalid Entry please try again.");
				i = -2;
			}
		}
		return guessNum;
	}
}

class Player {
	int myGuess;

	int myGuess(int n) {

		int i = -2;
		while (i == -2) {
			i = 1;
			Scanner scan = new Scanner(System.in);
			System.out.println("Player kindly guess the number between 1 to " + n);
			myGuess = scan.nextInt();
			if (myGuess < 1 || myGuess > n) {
				i = -2;
				System.out.println("Invalid Entry please Try again.");
			}
		}
		return myGuess;
	}

}

class Umpire {
	int numFromGuesser;
	int numFromPlayer;

	void collectNumFromGuesser(int n) {
		Guesser g = new Guesser();
		numFromGuesser = g.guessNum(n);
	}

	void collectNumFromPlayer(int n) {
		Player p = new Player();
		numFromPlayer = p.myGuess(n);
	}

	int compare(int mid) {
		if (mid < numFromGuesser)
			return 1;
		else if (mid > numFromGuesser)
			return -1;
		else
			return 0;

	}

	int findNumberGuessedByGuesser(int n) {
		collectNumFromGuesser(n);
		collectNumFromPlayer(n);
		int s = 1;
		int e = n;
		int mid = numFromPlayer;
		while (s <= e) {
			int pick = compare(mid);
			if (pick == 0)
				return mid;
			else if (pick == -1)
				e = mid - 1;
			else if (pick == 1)
				s = mid + 1;

			mid = (s + e) >> 1;
		}
		return -1;
	}

}

public class LaunchGame {

	public static void startGame(int n) {
		Umpire u = new Umpire();
		System.out.println("The Number Guessed By Guesser is " + u.findNumberGuessedByGuesser(n));
	}

	public static void main(String[] args) {

		// Game : Guesser is guessing the number between 1 to n and Umpire have to tell
		// which
		// no. is guess by Guesser.

		System.out.println("Guess the Range in which Guesser can Guess:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		startGame(n);

	}

}
