package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GiftFileDAO implements FileDAO {
    private List<Gift> gifts;

    public GiftFileDAO() {
        this.gifts = new ArrayList<>();
    }

    @Override
    public List<Gift> findAll() {
        return null;
    }

    @Override
    public Gift find(int id) throws EntityNotFoundException {
        Gift gift = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("resource/gifts.txt")));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                gift = new Gift();
                SweetFileDAO sweetFileDAO = new SweetFileDAO();

                gift.setId(Integer.parseInt(line));

                line = bufferedReader.readLine();

                if (gift.getId() == id) {
                    String[] content = line.split(" ");
                    for (String sweetId : content) {
                        Sweet sweet = sweetFileDAO.find(Integer.parseInt(sweetId));
                        gift.addSweet(sweet);
                    }

                    return gift;
                }

                gift = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (gift == null) {
            throw new EntityNotFoundException("Not found gift with id = " + id);
        }
        return null;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }
}
