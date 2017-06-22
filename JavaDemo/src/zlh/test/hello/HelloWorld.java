package zlh.test.hello;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 这是我的第一个java程序 <br>
 * 這個類是HelloWorld <br>
 * 測試用的<br>
 * 
 * @author ZhouLinhua <br>
 */
public class HelloWorld {
	
	//单纯使用log4j
	//private static Logger logger=Logger.getLogger(HelloWorld.class);
	
	//使用slf4j接口，实现可以是logback或者是log4j
	//使用slf4j+log4j，只要添加引用slf4j-log4j12-1.7.25.jar即可
	private static Logger logger=LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		// //枚举测试
		// System.out.println(MyColorsEnum.RED.value());

		// // lambda表达式测试
		// LambdaTest.normalFunc1();
		// LambdaTest.lambdaFunc1();

		// // 匿名类用法
		// ClassTest anonymousClassTest = new ClassTest();
		// int sum = anonymousClassTest.add(1, 2);
		// anonymousClassTest = new ClassTest() {
		// int add(int x, int y) {
		// String sum = Integer.toString(x) + Integer.toString(y);
		// return Integer.parseInt(sum);
		// }
		// };
		// int sum1 = anonymousClassTest.add(1, 2);
		// int dif = anonymousClassTest.sub(5, 2, 1);

		// // 匿名类改成lambda表达式
		// int sum2 = lambdaFun((int x, int y) -> {
		// return x + y;
		// }, 4, 5);
		// Adder adder = (x, y) -> x + y + x + y;
		// int sum3 = adder.add(4, 5);
		// System.out.println(sum + "|" + sum1 + "|" + dif + "|" + sum2 + "|" +
		// sum3);

		// lambda表达式，方法引用代替lambda表达式
		// Person[] people = { new Person("zhangsan", 22), new Person("lisi",
		// 39) };
		// Comparator<Person> byName = Comparator.comparing(p -> p.getAge());
		// Arrays.sort(people, byName);
		// List<Person> listPerson = new ArrayList<Person>();
		// listPerson.add(new Person("wangwu", 34));
		// listPerson.add(new Person("xiaoxiao", 23));
		// listPerson.sort(Comparator.comparing(p -> p.getAge()));
		// listPerson.sort(Comparator.comparing(Person::getName));
		System.out.println("hello hello hello");
		System.out.println("kitty kitty");
		System.out.println("!!!!!!");
		System.out.println("push之后提交 ，amend");
		System.out.println("能commit，但是push出错，重新修改和提交");
		System.out.println("测试reset---1");
		System.out.println("测试reset---2");
		System.out.println("测试reset---3");		
		System.out.println("测试push之后的reset--1");
		System.out.println("pull失败--REVERTING_RESOLVED");		
		System.out.println("push to upstream");
		System.out.println("改了github上的项目名称");
		
		//logger.fatal("logger.fatal");--log4j才有
		logger.error("logger.error");
		logger.warn("logger.warn");
		logger.info("logger.info");
		logger.debug("logger.debug");
		logger.trace("logger.trace");
		
	}

	static int lambdaFun(Adder value, int x, int y) {
		return value.add(x, y);
	}

	/**
	 * 加法函数，两个整数相加
	 * 
	 * @param i
	 *            加数
	 * @param j
	 *            被加数
	 * @return i+j 和
	 */
	public int add(int i, int j) {
		return i + j;

	}

	/**
	 * 两个整数相乘
	 * 
	 * @param i
	 *            乘数
	 * @param j
	 *            被乘数
	 * @return 积
	 */
	public int multiply(int i, int j) {
		return i * j;
	}

}
