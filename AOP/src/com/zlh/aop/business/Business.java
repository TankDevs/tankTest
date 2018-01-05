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
        String className=this.getClass().getName();
        String funcName = Thread.currentThread().getStackTrace()[1]
                .getMethodName();
        System.out.println("执行业务逻辑2:" + className+"-"+funcName);
    }

}
