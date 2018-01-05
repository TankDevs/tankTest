package com.zlh.aop.selfdefine;

import com.zlh.aop.business.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

//http://www.iteye.com/topic/1116696   
//3.3 自定义类加载器 
//如果我们实现了一个自定义类加载器，在类加载到JVM之前直接修改某些类的方法，
//并将切入逻辑织入到这个方法里，然后将修改后的字节码文件交给虚拟机运行，那岂不是更直接。

//Javassist是一个编辑字节码的框架，可以让你很简单地操作字节码。
//它可以在运行期定义或修改Class。使用Javassist实现AOP的原理是在字节码加载前直接修改需要切入的方法。
//这比使用Cglib实现AOP更加高效，并且没太多限制

// 我们使用系统类加载器启动我们自定义的类加载器，
//在这个类加载器里加一个类加载监听器，监听器发现目标类被加载时就织入切入逻辑，
//咱们再看看使用Javassist实现AOP的代码： 

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
