package zlh.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedThread implements Runnable {

	private String name;
	private int amount = 0;
	private Account account;
	private Lock lock = new ReentrantLock();

	public SynchronizedThread(int amount) {
		this.setAmount(amount);
	}

	public SynchronizedThread(Account account) {
		this.setAccount(account);		
	}

	public void run() {
		// runSynFunc();
		// runSynFunc1();
		// runSynBlock();
		runLock();

	}

	// synchronized 用在方法签名上
	public synchronized void runSynFunc() {
		for (int i = 0; i < 200; i++) {
			setAmount(getAmount() + 1);
			System.out.println(Thread.currentThread().getName() + ":" + getAmount());
		}
		System.out.println("runSynFunc结束---" + Thread.currentThread().getName() + ":" + getAmount());
	}

	// synchronized 用在方法签名上
	public synchronized void runSynFunc1() {
		for (int i = 0; i < 200000; i++) {
			this.account.add(1);
			System.out.println(Thread.currentThread().getName() + ":" + this.account.getBalance());
		}
		System.out.println("runSynFunc1结束---" + Thread.currentThread().getName() + ":" + this.account.getBalance());
	}

	public void runSynBlock() {
		synchronized (account) {
			for (int i = 0; i < 20000; i++) {
				this.account.add(1);
				// System.out.println(Thread.currentThread().getName() + ":" +
				// this.account.getBalance());
			}
			System.out.println("runSynBlock结束---" + Thread.currentThread().getName() + ":" + this.account.getBalance());

		}
	}

	public void runLock() {

		for (int i = 0; i < 2000; i++) {
			lock.lock();
			this.account.add(1);			
			 System.out.println(Thread.currentThread().getName() + ":" +
			 this.account.getBalance());
			 lock.unlock();
		}
		//System.out.println("runLock结束---" + Thread.currentThread().getName() + ":" + this.account.getBalance());

	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
