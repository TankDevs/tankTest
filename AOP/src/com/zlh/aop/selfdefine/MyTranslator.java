package com.zlh.aop.selfdefine;

import com.zlh.aop.business.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

//http://www.iteye.com/topic/1116696   
//3.3 �Զ���������� 
//�������ʵ����һ���Զ������������������ص�JVM֮ǰֱ���޸�ĳЩ��ķ�����
//���������߼�֯�뵽��������Ȼ���޸ĺ���ֽ����ļ�������������У������Ǹ�ֱ�ӡ�

//Javassist��һ���༭�ֽ���Ŀ�ܣ���������ܼ򵥵ز����ֽ��롣
//�������������ڶ�����޸�Class��ʹ��Javassistʵ��AOP��ԭ�������ֽ������ǰֱ���޸���Ҫ����ķ�����
//���ʹ��Cglibʵ��AOP���Ӹ�Ч������û̫������

// ����ʹ��ϵͳ����������������Զ�������������
//���������������һ������ؼ�����������������Ŀ���౻����ʱ��֯�������߼���
//�����ٿ���ʹ��Javassistʵ��AOP�Ĵ��룺 

public class MyTranslator implements Translator {

    public void start(ClassPool pool)
            throws NotFoundException, CannotCompileException {
    }

    /*
     * * ��װ�ص�JVMǰ���д���֯��
     */
    public void onLoad(ClassPool pool, String classname) {
        // if (!"model$Business".equals(classname)) {
        // return;
        // }
        // ͨ����ȡ���ļ�
        try {
            CtClass cc = pool.get(classname);
            // ���ָ���������ķ���
            CtMethod m = cc.getDeclaredMethod("doSomeThing");
            // �ڷ���ִ��ǰ�������
            m.insertBefore("{ System.out.println(\"��¼��־\"); }");
        } catch (NotFoundException e) {
        } catch (CannotCompileException e) {
        }
    }

    public static void main(String[] args) {
        Business b = new Business();
        b.doSomeThing2();
        b.doSomeThing();
    }
}
