package zlh.test.thread;

public class MyThreadImplRunnable implements Runnable {
    private int ticket = 10;

    // �߳���
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("ѭ��������" + i);
            if (this.ticket > 0) {
                System.out.println("MyThreadImplRunnable--��Ʊ��ticket:" + this.ticket--);
            }
        }
    }
}
