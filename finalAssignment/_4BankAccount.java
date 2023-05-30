package in.code.finalAssignment;

import java.util.Scanner;

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("$" + amount + " deposited.");
	}

	public void withdraw(double amount) {
		if (balance < amount) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
			System.out.println("$" + amount + " withdrawn.");
		}
	}

	public void checkBalance() {
		System.out.println("Your balance is $" + balance);
	}

}

public class _4BankAccount {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter initial balance: ");
		double initialBalance = scanner.nextDouble();

		BankAccount account = new BankAccount(initialBalance);

		while (true) {
			System.out.println("\n1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Quit");
			System.out.print("Enter choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				account.checkBalance();
				break;
			case 4:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}
}
