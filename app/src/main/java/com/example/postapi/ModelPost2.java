package com.example.postapi;

public class ModelPost2 {

    private int userId;
    private Integer id;
    private String title;
    private String body;

    public ModelPost2(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
