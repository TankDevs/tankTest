package com.zlh.aop.spring;

public class PersonServiceBean implements PersonServer {

    @Override
    public void save(String name) {

        System.out.println("����save����");
        // throw new RuntimeException();
    }

    @Override
    public void update(String name, Integer id) {

        System.out.println("����update()����");
    }

    @Override
    public String getPersonName(Integer id) {

        System.out.println("����getPersonName()����");
        return "xxx";
    }

}
