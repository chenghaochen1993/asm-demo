package com.cch.asmdemo.model;

/**
 * @author: chenghao.chen
 * @date: 2019/11/2 12:12
 * @description:
 */
public abstract class Staff {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept()throws Exception;
}
