package zlh.test.callback;

/**
 * 这个是小王 实现了一个回调接口CallBack，相当于----->背景一
 */

// public class Wang implements ICallBack {
public class Wang {
	/**
	 * 小李对象的引用 相当于----->背景二
	 */
	private Li li;

	/**
	 * 小王的构造方法，持有小李的引用
	 * 
	 * @param li
	 */
	public Wang(Li li) {
		this.li = li;
	}

	/**
	 * 小王通过这个方法去问小李的问题
	 * 
	 * @param question
	 *            就是小王要问的问题,1 + 1 = ?
	 */
	public void askQuestion(final String question) {
		System.out.println("小王问的问题--->" + question);
		// //同步方式
		// try {
		// li.executeMessage(Wang.this, question);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// 这里用一个线程就是异步，
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 小王调用小李中的方法，在这里注册回调接口 这就相当于A类调用B的方法C
				try {
					// li.executeMessage(Wang.this, question);
					li.executeMessage(Wang.this, "callBackFunc", question);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// 小网问完问题挂掉电话就去干其他的事情了，逛街去了
		play();
	}

	public void play() {
		System.out.println("我要逛街去了");
	}

	/**
	 * 小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法
	 */
	//@Override
	public void callBackFunc(String result) {
		System.out.println("小李告诉小王的答案是--->" + result);
	}

	public void stop() {
		li.stopFlag = true;
	}

}
