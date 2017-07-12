package zlh.test.exception;

public class ExceptionProgram {

	public static void main(String[] args) {
		try {
			System.out.println("结果：" + divideMyEx(232, 0));
		} catch (MyException e) {
			System.out.println("hahha");
		}catch (Exception e) {
			System.out.println("异常msg：" + e.getMessage());
			System.out.println("异常string：" + e.toString());
			e.printStackTrace();
		}

	}

	static private double divideMyEx(int i, int j) {
		try {
			return i / j;

		} catch (Exception e) {
			throw new MyException("自定义exception-" + e.toString());
		}

	}

	static private double divideEx(int i, int j) {
		double result = 0;
		// try {
		result = i / j;
		// } catch (Exception e) {

		// }
		return result;
	}

	static private double throwMyEx(int i, int j) throws MyException {
		double result = 0;
		result = i + j;
		if (result > 0) {
			throw new MyException("抛出一个自定义异常");
		}
		return result;
	}

}
