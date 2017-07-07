package zlh.test.equals;

public class EqualsProgram {

	public static void main(String[] arg) {
		 int i = 4;
		 int j = 4;
		 System.out.println("==:" + (i == j));
		
		 Integer i1 = 4;
		 Integer j1 = 4;
		 System.out.println("==:" + (i1 == j1));
		 System.out.println("equals:" + i1.equals(j1));
		
		 Integer i2 = new Integer(4);
		 Integer j2 = new Integer(4);
		 System.out.println("==:" + (i2 == j2));
		 System.out.println("equals:" + i2.equals(j2));

		 String s1="Hello";
		 String s2="Hello";
		 String s3=new String("Hello");
		 String s4=new String("Hello");
		 System.out.println("==:" + (s1 == s2));
		 System.out.println("equals:" + s1.equals(s2));
		 System.out.println("==:" + (s3 == s4));
		 System.out.println("equals:" + s3.equals(s4));
		 System.out.println("==:" + (s2 == s3));
		 System.out.println("equals:" + s3.equals(s4));

		Person p1 = new Person("zhangsan", 23);
		Person p2 = new Person("zhangsan", 23);
		Person p3=p1;
		System.out.println("==:" + (p1 == p3));
		System.out.println("equals:" + p1.equals(p3));
	}
}
