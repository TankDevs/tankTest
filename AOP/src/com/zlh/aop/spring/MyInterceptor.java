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
     * @Pointcut ����ʾ�涨����� execution() �﷨�淶 ��һ����*����ʾ���ⷵ�ؽ������
     *           ��com.zlh.aop.spring.PersonServiceBean������ʾ�Դ���������أ�
     *           �����com.zlh.aop.spring..*.*����ʾ�԰�cn.itcast.service�Լ��Ӱ������е�������з����������أ�
     *           (..)��ʾ����
     * 
     *           �ܽ� spring 3.x ��aop����������������Ϊ�� 1.��������(���������pointcut��֪ͨadvice)��
     *           2.��spring�����ڵ���Beanʱ���������excution�еĸ�ʽ������㣩����ô�ͽ�֪ͨ��advice�����뵽��������С�
     *           ֪ͨ��ǰ�ã����á�����֪ͨ�ȵ�
     */

    @Pointcut("execution(* com.zlh.aop.spring.PersonServiceBean.*(..))")
    private void anyMethod() {
        System.out.println("�����-anyMethod");
    }// ����һ�������

    // ��ʱ��ǰ��֪ͨ��ֻ�����ص���������������ƥ��ķ���
    // args(name)�е�name����ͷ���doAccessCheck�Ĳ���һ��
    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name) {
        System.out.println(name);
        System.out.println("ǰ��֪ͨ");
    }

    // �õ������ķ���ֵ
    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("����֪ͨ");
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("����֪ͨ");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("����֪ͨ");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("���뻷��֪ͨ");
        Object object = pjp.proceed();// ִ�и÷���
        System.out.println("�˳�����");
        return object;
    }
}
