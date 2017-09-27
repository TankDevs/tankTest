package com.zlh.aop.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestSpring {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "beanAop.xml");
        PersonServer bean = (PersonServer) ctx.getBean("personServiceBean");
        bean.save("zhangsan-save");
        bean.update("zhangsan-update", 98);
        bean.getPersonName(92);

    }

}
