package com.zlh.aop.selfdefine;

import com.zlh.aop.business.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

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
