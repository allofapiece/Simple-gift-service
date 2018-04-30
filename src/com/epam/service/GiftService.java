package com.epam.service;

import com.epam.dao.AbstractFactory;
import com.epam.dao.Factory;
import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class GiftService {
    private FileDAO<Gift> dao;

    public GiftService() {
        Factory<Factory> aFactory = new AbstractFactory();
        Factory<FileDAO> fileDAOFactory = aFactory.create("textFileDAO");
        this.dao = fileDAOFactory.create("gift");
    }

    public Gift find(int id) {
        Gift gift = null;

        try {
            gift = this.dao.find(id);
        } catch (EntityNotFoundException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }

        return gift;
    }

    public Gift sort(Gift gift, String sortType) {
        switch (sortType) {
            case "name":
                gift.getSweets().sort(new Comparator<Sweet>() {
                    @Override
                    public int compare(Sweet o1, Sweet o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;

            case "sweetType":
                gift.getSweets().sort(new Comparator<Sweet>() {
                    @Override
                    public int compare(Sweet o1, Sweet o2) {
                        return o1.getType().compareTo(o2.getType());
                    }
                });
                break;

            default:
                break;
        }

        return gift;
    }

    public float calculateGiftWeight(Gift gift) {
        float totalWeight = 0;

        for (Sweet sweet : gift.getSweets()) {
            totalWeight += sweet.getWeight();
        }

        return totalWeight;
    }

    public Set<Sweet> sugarFilter(Gift gift, float min, float max){
        HashSet<Sweet> filteredSweets = new HashSet<>();

        for (Sweet sweet : gift.getSweets()) {
            if ((sweet.getSugar() >= min) && (sweet.getSugar() <= max)){
                filteredSweets.add(sweet);
            }
        }

        return filteredSweets;
    }
}
