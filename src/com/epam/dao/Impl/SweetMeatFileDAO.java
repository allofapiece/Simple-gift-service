package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.SweetMeat;

import java.util.ArrayList;
import java.util.List;

public class SweetMeatFileDAO implements FileDAO {
    private List<SweetMeat> sweetMeats;

    public SweetMeatFileDAO(){
        this.sweetMeats = new ArrayList<SweetMeat>();
    }
    @Override
    public List<SweetMeat> findAll() {
        return null;
    }

    @Override
    public SweetMeat find(int id) {
        return null;
    }

    public List<SweetMeat> getSweetMeats() {
        return sweetMeats;
    }

    public void setSweetMeats(List<SweetMeat> sweetMeats) {
        this.sweetMeats = sweetMeats;
    }
}
