package zlh.test.thread;

public class SynchronizedPragram {
	public static void main(String[] args) {
		try {
		
//			int result = 0;
//			SynchronizedThread synchronizedThread=new SynchronizedThread(result);
			SynchronizedThread synchronizedThread=new SynchronizedThread(new Account(0));
			Thread t1= new Thread( synchronizedThread);						
			Thread t2= new Thread( synchronizedThread);
			t1.start();
			t2.start();
			t1.join();
			t2.join();			
			System.out.println(synchronizedThread.getAccount().getBalance());
			return;
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			//System.out.println("finally");
		}
	}
}
