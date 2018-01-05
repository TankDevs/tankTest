package com.zlh.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//http://www.iteye.com/topic/1116696  
//3.1 ��̬����
//Java��JDK1.3������Ķ�̬������ƣ�ʹ���ǿ����������ڶ�̬�Ĵ��������ࡣ
//ʹ�ö�̬����ʵ��AOP��Ҫ���ĸ���ɫ����������࣬��������Ľӿڣ�֯��������InvocationHandler��
//��֯����ʹ�ýӿڷ����������һ�������࣬Ȼ���������������֯����롣�����������AOP����˵��Ŀ�꣬
//InvocationHandler�����棬��������Advice��Pointcut�� 
/**
 * ��ӡ��־������
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target; // Ŀ�����

    LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // ִ��ԭ���߼�
        Object rev = method.invoke(target, args);
        // ִ��֯�����־������Կ�����Щ����ִ�������߼�
        // if (method.getName().equals("doSomeThing2"))
        System.out.println("��¼��־:" + method.getName());
        return rev;
    }
}