package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Chocolate;

import java.util.ArrayList;
import java.util.List;

public class ChocolateFileDAO implements FileDAO {
    private List<Chocolate> chocolates;

    public ChocolateFileDAO(){
        this.chocolates = new ArrayList<Chocolate>();
    }

    @Override
    public List<Chocolate> findAll() {
        return null;
    }

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }
}
