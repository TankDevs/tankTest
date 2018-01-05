package com.zlh.aop.selfdefine;

import org.junit.Before;
import org.junit.Test;

import javassist.ClassPool;
import javassist.Loader;


public class UnitTestSelfDefine {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Throwable{
       
      //获取存放CtClass的容器ClassPool 
        ClassPool cp = ClassPool.getDefault(); 
        //创建一个类加载器 
        Loader cl = new Loader(); 
        //增加一个转换器 
        cl.addTranslator(cp, new MyTranslator()); 
        //启动MyTranslator的main函数 
        String[] args={""};
      //单元测试失败!!!!!!!
        cl.run("UnitTestSelfDefine", args); 

    }

}
