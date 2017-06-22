package zlh.test.callback;

import java.lang.reflect.Method;

/**
 * 这个就是小李啦，回答问题
 *
 */
public class Li {

	public boolean stopFlag = false;

	/**
	 * 相当于B类有参数为CallBack callBack的f()---->背景三
	 * 
	 * @param callBack
	 * @param question
	 *            小王问的问题
	 * @throws InterruptedException
	 */
	// public void executeMessage(ICallBack callBack, String question) throws
	// InterruptedException {
	public void executeMessage(Object callBack, String functionName, String question) throws InterruptedException {
		System.out.println("收到小王的问题--->" + question);
		int count = 0;
		// 不停地告诉答案
		while (!stopFlag) {
			++count;
			// 模拟小李办自己的事情需要很长时间
			Thread.sleep(1000);
			/**
			 * 小李办完自己的事情之后想到了答案是2
			 */
			String result = "答案是2";

			/**
			 * 于是就打电话告诉小王，调用小王中的方法 这就相当于B类反过来调用A的方法D
			 */
			// callBack.callBackFunc("");

			// 使用反射实现
			try {
				Method method = callBack.getClass().getMethod(functionName, String.class);
				method.invoke(callBack, result + "--第" + count + "次回答。");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				stopFlag = true;
				System.out.println("无法找到" + callBack + "对象中的方法" + functionName);
				e.printStackTrace();

			}
		}

	}

}
