package com.cch.asmdemo.model;

/**
 * @author: chenghao.chen
 * @date: 2019/11/2 11:47
 * @description:
 */
public class Enginer extends Staff {
    public Integer age;

    private static final String TYPE="1";

    public Enginer() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void accept()throws Exception {
        System.out.println("accept");
    }
}
