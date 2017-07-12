package zlh.test.exception;

public class ExceptionProgram {

	public static void main(String[] args) {
		try {
			System.out.println("�����" + divideMyEx(232, 0));
		} catch (MyException e) {
			System.out.println("hahha");
		}catch (Exception e) {
			System.out.println("�쳣msg��" + e.getMessage());
			System.out.println("�쳣string��" + e.toString());
			e.printStackTrace();
		}

	}

	static private double divideMyEx(int i, int j) {
		try {
			return i / j;

		} catch (Exception e) {
			throw new MyException("�Զ���exception-" + e.toString());
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
			throw new MyException("�׳�һ���Զ����쳣");
		}
		return result;
	}

}
