package com.example.postapi;

public class AnimModel {

    private int uid;


    private String anime;


    private String character;


    private String quote;

    public AnimModel(String anime, String character, String quote) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    public int getUid() {
        return uid;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }
}
