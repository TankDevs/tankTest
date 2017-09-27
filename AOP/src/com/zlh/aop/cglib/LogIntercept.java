package com.zlh.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//JDK的动态代理用起来非常简单，但是它有一个限制，就是使用动态代理的对象必须实现一个或多个接口 。
//如果想代理没有实现接口的类可以使用CGLIB包。
//使用动态字节码生成技术实现AOP原理是在运行期间目标字节码加载后，
//生成目标类的子类，将切面逻辑加入到子类中，所以使用Cglib实现AOP不需要基于接口。
/**
 * 记录日志
 */
public class LogIntercept implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        // 执行原有逻辑，注意这里是invokeSuper
        Object rev = proxy.invokeSuper(target, args);
        // 执行织入的日志
        // if (method.getName().equals("doSomeThing2")) {
        System.out.println("记录日志" + method.getName());
        return rev;
    }
}
