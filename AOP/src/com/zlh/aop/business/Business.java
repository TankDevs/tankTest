package com.zlh.aop.business;

//http://www.iteye.com/topic/1116696
public class Business implements IBusiness, IBusiness2 {

    @Override
    public boolean doSomeThing() {
        System.out.println("执行业务逻辑");
        return true;
    }

    @Override
    public void doSomeThing2() {
        System.out.println("执行业务逻辑2");
    }

}
