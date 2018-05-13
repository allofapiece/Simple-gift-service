package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Gift {
    private List<Sweet> sweets;
    private int id;

    public Gift() {
        sweets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    public void setSweets(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public void addSweet(Sweet sweet) {
        if (sweet != null) {
            sweets.add(sweet);
        }
    }

    public void removeSweet(Sweet sweet) {
        if (sweet != null) {
            sweets.remove(sweet);
        }
    }
}
