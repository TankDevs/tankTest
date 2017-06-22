package zlh.test.callback;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		Li xiaoLi=new Li();	
		Wang xiaoWang=new Wang(xiaoLi);
		xiaoWang.askQuestion("1+1=?");
		Thread.sleep(5*1000);
		xiaoWang.stop();
	}

//	public void callBackFun() {
//		System.out.println("callBackFun");
//
//	}
//
//	public void doSomething(int i, String call) {
//		System.out.println("doSomething");
//
//	}
}
