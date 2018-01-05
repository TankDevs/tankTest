package com.zlh.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//http://www.iteye.com/topic/1116696  
//3.2 ��̬�ֽ������� 
//JDK�Ķ�̬�����������ǳ��򵥣���������һ�����ƣ�����ʹ�ö�̬����Ķ������ʵ��һ�������ӿ� ��
//��������û��ʵ�ֽӿڵ������ʹ��CGLIB����
//ʹ�ö�̬�ֽ������ɼ���ʵ��AOPԭ�����������ڼ�Ŀ���ֽ�����غ�
//����Ŀ��������࣬�������߼����뵽�����У�����ʹ��Cglibʵ��AOP����Ҫ���ڽӿڡ�
//���ڽ������ʹ��Cglib��ʵ�ֶ�̬�ֽ��뼼����Cglib��һ��ǿ���,�����ܵ�Code������⣬
//�������������ڼ���չJava���ʵ��Java�ӿڣ�����װ��Asm������ʹ��Cglibǰ��Ҫ����Asm��jar�� 
/**
 * ��¼��־
 */
public class LogIntercept implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args,
            MethodProxy proxy) throws Throwable {
        // ִ��ԭ���߼���ע��������invokeSuper
        Object rev = proxy.invokeSuper(target, args);
        // ִ��֯�����־
        // if (method.getName().equals("doSomeThing2")) {
        System.out.println("��¼��־" + method.getName());
        return rev;
    }
}
