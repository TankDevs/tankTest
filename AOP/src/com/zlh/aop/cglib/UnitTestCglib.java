package com.zlh.aop.cglib;

import org.junit.Before;
import org.junit.Test;

import com.zlh.aop.business.Business;

import net.sf.cglib.proxy.Enhancer;

public class UnitTestCglib {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        // ����һ��֯����
        Enhancer enhancer = new Enhancer();
        // ���ø���
        enhancer.setSuperclass(Business.class);
        // ������Ҫ֯����߼�
        enhancer.setCallback(new LogIntercept());
        // ʹ��֯������������
        Business newBusiness = (Business) enhancer.create();
        newBusiness.doSomeThing2();
        newBusiness.doSomeThing();

    }

}
