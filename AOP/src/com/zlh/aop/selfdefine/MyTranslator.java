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
     * * 类装载到JVM前进行代码织入
     */
    public void onLoad(ClassPool pool, String classname) {
        // if (!"model$Business".equals(classname)) {
        // return;
        // }
        // 通过获取类文件
        try {
            CtClass cc = pool.get(classname);
            // 获得指定方法名的方法
            CtMethod m = cc.getDeclaredMethod("doSomeThing");
            // 在方法执行前插入代码
            m.insertBefore("{ System.out.println(\"记录日志\"); }");
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
