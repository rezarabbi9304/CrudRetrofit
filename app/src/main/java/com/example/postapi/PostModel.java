package com.example.postapi;

public class PostModel {
    private String name;
    private int salary;
    private int age;
/*    private int id;*/

    private int id;
    private int userId;
    private String title;
    private String body;

    public PostModel( int userId, String title, String body) {

        this.userId = userId;
        this.title = title;
        this.body = body;
    }
/*   public PostModel(String name, int salary, int age, int id) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }*/


    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
