package zlh.test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//http://blog.csdn.net/zixiao217/article/details/52951679
//http://blog.csdn.net/anders_zhuo/article/details/8955226
//JUnit4ʹ��Java5�е�ע�⣨annotation����������JUnit4���õļ���annotation�� 
//@Before����ʼ������   ����ÿһ�����Է�����Ҫִ��һ�Σ�ע����BeforeClass���𣬺����Ƕ������з���ִ��һ�Σ�
//@After���ͷ���Դ  ����ÿһ�����Է�����Ҫִ��һ�Σ�ע����AfterClass���𣬺����Ƕ������з���ִ��һ�Σ�
//@Test�����Է�������������Բ��������쳣�ͳ�ʱʱ�� 
//@Test(expected=ArithmeticException.class)��鱻�ⷽ���Ƿ��׳�ArithmeticException�쳣 
//@Ignore�����ԵĲ��Է��� 
//@BeforeClass��������в��ԣ�ִֻ��һ�Σ��ұ���Ϊstatic void 
//@AfterClass��������в��ԣ�ִֻ��һ�Σ��ұ���Ϊstatic void 
//һ��JUnit4�ĵ�Ԫ��������ִ��˳��Ϊ�� 
//@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
//ÿһ�����Է����ĵ���˳��Ϊ�� 
//@Before -> @Test -> @After; 

public class JunitAnnotationTest {
    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
        // fail("dd");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
        // fail("");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
        // fail("");
    }

    // @Ignore
    @Test
    public void test_method_3() {
        System.out.println("@Test - test_method_3");

    }

    @Test // (timeout = 50)
    public void testTimeout() {
        System.out.println("@Test(timeout = 50)");
        assertEquals(5 + 5, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testExpected() {
        System.out.println("@Test(expected = Exception.class)");
        throw new ArithmeticException("cuwo");
    }
}