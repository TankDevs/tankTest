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
       
      //��ȡ���CtClass������ClassPool 
        ClassPool cp = ClassPool.getDefault(); 
        //����һ��������� 
        Loader cl = new Loader(); 
        //����һ��ת���� 
        cl.addTranslator(cp, new MyTranslator()); 
        //����MyTranslator��main���� 
        String[] args={""};
      //��Ԫ����ʧ��!!!!!!!
        cl.run("UnitTestSelfDefine", args); 

    }

}
