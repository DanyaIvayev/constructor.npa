package com.example.constructor.npa;

/**
 * Created by root on 9/5/17.
 */
public class Nodepath {
    private final long id;
    private final String content;

    public Nodepath(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
