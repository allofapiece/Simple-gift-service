package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Chocolate;
import com.epam.entity.Gift;

import java.util.ArrayList;
import java.util.List;

public class GiftFileDAO implements FileDAO {
    private List<Gift> gifts;

    public GiftFileDAO(){
        this.gifts = new ArrayList<Gift>();
    }

    @Override
    public List<Gift> findAll() {
        return null;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }
}
