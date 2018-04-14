package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Candy;

import java.util.ArrayList;
import java.util.List;

public class CandyFileDAO implements FileDAO {
    private List<Candy> candies;

    public CandyFileDAO(){
        this.candies = new ArrayList<Candy>();
    }

    @Override
    public List<Candy> findAll() {
        return null;
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }
}
