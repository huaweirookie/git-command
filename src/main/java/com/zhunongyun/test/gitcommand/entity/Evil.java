package com.zhunongyun.test.gitcommand.entity;

import java.io.IOException;

public class Evil {

    public String name;

    private int age;

    public String getName() {
        System.out.println("i am getterName!");
        return name;
    }

    public void setName(String name) {
        System.out.println("i am setterName!");
        this.name = name;
    }

    public int getAge() {
        System.out.println("i am getterAge!");
        return age;
    }

    public void setAge(int age) {
        System.out.println("i am setterAge!");
        this.age = age;
    }

    public Evil() throws IOException {
        System.out.println("i am constructor!");
        Runtime.getRuntime().exec("open /Applications/Calculator.app");
    }
}