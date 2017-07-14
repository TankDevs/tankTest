package zlh.test.thread;

public class Account {

	private int balance = 0;

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void add(int num) {
		balance = balance + num;
	}
}
