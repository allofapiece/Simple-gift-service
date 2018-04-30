package com.epam.entity;

public class Sweet extends EdibleProduct {
    private SweetType type;

    public SweetType getType() {
        return type;
    }

    public void setType(SweetType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sweet id = " + getId() + "\n" +
                "type = " + type + "\n" +
                "name = " + getName() + " \n" +
                "weight = " + getWeight() + "\n" +
                "sugar = " + getSugar() + "\n";
    }
}
