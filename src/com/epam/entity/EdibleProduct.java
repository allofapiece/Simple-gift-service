package com.epam.entity;

public class EdibleProduct extends Product {
    private float sugar;
    private String name;

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
