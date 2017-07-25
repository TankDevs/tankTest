package zlh.test.annotation;

import java.lang.reflect.Field;

/*********** Êä³ö½á¹û ***************/
public class FruitRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// FruitInfoUtil.getFruitInfo(Apple.class);
		Apple apple = new Apple();
		Field[] fields = apple.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fn = (FruitProvider) field.getAnnotation(FruitProvider.class);
				System.out.println(fn.address());
			}		
		}
		System.out.println(apple.getAppleColor());
		System.out.println(apple.getAppleProvider());
	}

}