package com.zlh.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//http://www.iteye.com/topic/1116696  
//3.1 动态代理
//Java在JDK1.3后引入的动态代理机制，使我们可以在运行期动态的创建代理类。
//使用动态代理实现AOP需要有四个角色：被代理的类，被代理类的接口，织入器，和InvocationHandler，
//而织入器使用接口反射机制生成一个代理类，然后在这个代理类中织入代码。被代理的类是AOP里所说的目标，
//InvocationHandler是切面，它包含了Advice和Pointcut。 
/**
 * 打印日志的切面
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target; // 目标对象

    LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // 执行原有逻辑
        Object rev = method.invoke(target, args);
        // 执行织入的日志，你可以控制哪些方法执行切入逻辑
        // if (method.getName().equals("doSomeThing2"))
        System.out.println("记录日志:" + method.getName());
        return rev;
    }
}