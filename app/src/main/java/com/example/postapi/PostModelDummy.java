package com.example.postapi;

public class PostModelDummy {

    private String name;
    private int salary;
    private int age;
    private Integer id;

    public PostModelDummy(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
