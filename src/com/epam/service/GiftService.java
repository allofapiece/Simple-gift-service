package com.epam.service;

import com.epam.comparator.SweetNameComparator;
import com.epam.comparator.SweetTypeComparator;
import com.epam.dao.AbstractFactory;
import com.epam.dao.Factory;
import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.exc.EntityNotFoundException;

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
                gift.getSweets().sort(new SweetNameComparator());
                break;

            case "sweetType":
                gift.getSweets().sort(new SweetTypeComparator());
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
}
