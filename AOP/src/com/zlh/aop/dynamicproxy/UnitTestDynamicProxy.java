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
        // 需要代理的接口，被代理类实现的多个接口都必须在这里定义
        Class[] proxyInterface = new Class[] { IBusiness.class,
                IBusiness2.class };
        // 构建AOP的Advice，这里需要传入业务类的实例
        LogInvocationHandler handler = new LogInvocationHandler(new Business());
       
        
        // 生成代理类的字节码加载器
        ClassLoader classLoader = Business.class.getClassLoader();
        // 织入器，织入代码并生成代理类
        IBusiness2 proxyBusiness = (IBusiness2) Proxy
                .newProxyInstance(classLoader, proxyInterface, handler);
        // 使用代理类的实例来调用方法。
        proxyBusiness.doSomeThing2();
        ((IBusiness) proxyBusiness).doSomeThing();
        
        
        
    }

}
