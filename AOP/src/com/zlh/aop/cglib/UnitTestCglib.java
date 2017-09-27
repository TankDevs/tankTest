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
        // 创建一个织入器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(Business.class);
        // 设置需要织入的逻辑
        enhancer.setCallback(new LogIntercept());
        // 使用织入器创建子类
        Business newBusiness = (Business) enhancer.create();
        newBusiness.doSomeThing2();
        newBusiness.doSomeThing();

    }

}
