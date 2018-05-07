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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EdibleProduct that = (EdibleProduct) o;

        if (Float.compare(that.sugar, sugar) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sugar != +0.0f ? Float.floatToIntBits(sugar) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "sugar = " + sugar + '\n' +
                "name = " + name + '\n';
    }
}
