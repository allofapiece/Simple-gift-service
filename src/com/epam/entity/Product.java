package com.epam.entity;

public class Product {
    private int id;

    private float weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return Float.compare(product.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (weight != +0.0f ? Float.floatToIntBits(weight) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id = " + id + '\n' +
                "weight = " + weight + '\n';
    }
}
