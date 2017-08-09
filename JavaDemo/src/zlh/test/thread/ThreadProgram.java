package zlh.test.thread;

public class ThreadProgram {
    public static void main(String[] args) {
        try {
            MyThreadExtendsThread myThread1 = new MyThreadExtendsThread();
            MyThreadExtendsThread myThread2 = new MyThreadExtendsThread();
            MyThreadExtendsThread myThread3 = new MyThreadExtendsThread();
            myThread1.start();
            myThread2.start();
            myThread3.start();
            myThread1.run();
            myThread2.run();
            myThread3.run();
            MyThreadImplRunnable mt = new MyThreadImplRunnable();
            new Thread(mt).start();// 同一个mt，但是在Thread中就不可以，如果用同一
            new Thread(mt).start();// 个实例化对象mt，就会出现异常
            new Thread(mt).start();
            new Thread(mt).run();
            new Thread(mt).run();
            new Thread(mt).run();
            return;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            // System.out.println("finally");
        }
    }
}
