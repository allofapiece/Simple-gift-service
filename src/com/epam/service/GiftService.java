package com.epam.service;

import com.epam.dao.AbstractFactory;
import com.epam.dao.Factory;
import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class GiftService {
    private static final Logger log = Logger.getLogger(GiftService.class);
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
            log.error("EntityNotFoundException thrown", ex);
        }

        return gift;
    }

    public Gift sort(Gift gift, String sortType) {
        switch (sortType) {
            case "name":
                gift.getSweets().sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                log.debug("Sweets is sorted by name");
                break;

            case "sweetType":
                gift.getSweets().sort((o1, o2) -> o1.getType().compareTo(o2.getType()));
                log.debug("Sweets is sorted by sweet type");
                break;

            default:
                log.error("This criteria is not exist");
                break;
        }

        return gift;
    }

    public float calculateGiftWeight(Gift gift) {
        float totalWeight = 0;

        for (Sweet sweet : gift.getSweets()) {
            totalWeight += sweet.getWeight();
        }
        log.debug("Gift weight is calculated");

        return totalWeight;
    }

    public Set<Sweet> sugarFilter(Gift gift, float min, float max){
        HashSet<Sweet> filteredSweets = new HashSet<>();

        for (Sweet sweet : gift.getSweets()) {
            if ((sweet.getSugar() >= min) && (sweet.getSugar() <= max)){
                filteredSweets.add(sweet);
            }
        }
        log.debug("Sweets of gift with id = " + gift.getId() +
                " are filtered by min sugar = " + min +
                " and max sugar = " + max);

        return filteredSweets;
    }
}
