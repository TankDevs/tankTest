package com.zlh.aop.dynamicproxy;

import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

import com.zlh.aop.business.Business;
import com.zlh.aop.business.IBusiness;
import com.zlh.aop.business.IBusiness2;

public class UnitTestDynamicProxy {

    @Before
    public void setUp() throws Exception {
    }
    
    public LogInvocationHandler ProxyBusiness(LogInvocationHandler h){
    return h;
    }

    @Test
    public void test() {
        // ��Ҫ����Ľӿڣ���������ʵ�ֵĶ���ӿڶ����������ﶨ��
        Class[] proxyInterface = new Class[] { IBusiness.class,
                IBusiness2.class };
        // ����AOP��Advice��������Ҫ����ҵ�����ʵ��
        LogInvocationHandler handler = new LogInvocationHandler(new Business());
       
        
        // ���ɴ�������ֽ��������
        ClassLoader classLoader = Business.class.getClassLoader();
        // ֯������֯����벢���ɴ�����
        IBusiness2 proxyBusiness = (IBusiness2) Proxy
                .newProxyInstance(classLoader, proxyInterface, handler);
        // ʹ�ô������ʵ�������÷�����
        proxyBusiness.doSomeThing2();
        ((IBusiness) proxyBusiness).doSomeThing();
        
        
        
    }

}
