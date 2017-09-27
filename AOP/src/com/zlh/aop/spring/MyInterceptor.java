package com.zlh.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//http://blog.csdn.net/tangzenglei/article/details/50341065
//http://blog.csdn.net/a352193394/article/details/7345860
@Aspect
public class MyInterceptor {

    /**
     * @Pointcut ：表示规定切入点 execution() 语法规范 第一个“*”表示任意返回结果类型
     *           “com.zlh.aop.spring.PersonServiceBean”：表示对此类进行拦截，
     *           如果是com.zlh.aop.spring..*.*：表示对包cn.itcast.service以及子包里所有的类的所有方法进行拦截，
     *           (..)表示参数
     * 
     *           总结 spring 3.x 的aop容器大致运行流程为： 1.定义切面(包括切入点pointcut和通知advice)。
     *           2.当spring容器在调用Bean时，如果满足excution中的格式（切入点），那么就将通知（advice）插入到该切入点中。
     *           通知：前置，后置、环绕通知等等
     */

    @Pointcut("execution(* com.zlh.aop.spring.PersonServiceBean.*(..))")
    private void anyMethod() {
        System.out.println("切入点-anyMethod");
    }// 定义一个切入点

    // 此时的前置通知，只能拦截到参数个数和类型匹配的方法
    // args(name)中的name必须和方法doAccessCheck的参数一至
    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name) {
        System.out.println(name);
        System.out.println("前置通知");
    }

    // 得到方法的返回值
    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("退出方法");
        return object;
    }
}
