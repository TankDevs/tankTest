package zlh.test.thread;

public class MyThreadImplRunnable implements Runnable {
    private int ticket = 10;

    // 线程体
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("循环次数：" + i);
            if (this.ticket > 0) {
                System.out.println("MyThreadImplRunnable--卖票：ticket:" + this.ticket--);
            }
        }
    }
}
