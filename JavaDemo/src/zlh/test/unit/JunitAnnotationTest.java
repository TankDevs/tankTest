package zlh.test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//http://blog.csdn.net/zixiao217/article/details/52951679
//http://blog.csdn.net/anders_zhuo/article/details/8955226
//JUnit4使用Java5中的注解（annotation），以下是JUnit4常用的几个annotation： 
//@Before：初始化方法   对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
//@After：释放资源  对于每一个测试方法都要执行一次（注意与AfterClass区别，后者是对于所有方法执行一次）
//@Test：测试方法，在这里可以测试期望异常和超时时间 
//@Test(expected=ArithmeticException.class)检查被测方法是否抛出ArithmeticException异常 
//@Ignore：忽略的测试方法 
//@BeforeClass：针对所有测试，只执行一次，且必须为static void 
//@AfterClass：针对所有测试，只执行一次，且必须为static void 
//一个JUnit4的单元测试用例执行顺序为： 
//@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
//每一个测试方法的调用顺序为： 
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