package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Candy;
import com.epam.exc.EntityNotFoundException;
import com.epam.service.Properties;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CandyFileDAO implements FileDAO {

    private File file;

    public CandyFileDAO(){
    }

    @Override
    public List<Candy> findAll() {
        Properties properties = new Properties();
        List<Candy> candies = new ArrayList<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(properties.getMainProperty("dao.candy"))));
            String line;
            Candy candy;
            while ((line = bufferedReader.readLine()) != null){
                candy = new Candy();

                candy.setId(Integer.parseInt(line));
                candy.setName(bufferedReader.readLine());
                candy.setWeight(Float.parseFloat(bufferedReader.readLine()));
                candy.setSugar(Float.parseFloat(bufferedReader.readLine()));

                candies.add(candy);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return candies;
    }

    public Candy find(int id) throws EntityNotFoundException{
        Properties properties = new Properties();
        List<Candy> candies = new ArrayList<>();
        Candy candy = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(properties.getMainProperty("dao.candy"))));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                candy = new Candy();

                candy.setId(Integer.parseInt(line));
                candy.setName(bufferedReader.readLine());
                candy.setWeight(Float.parseFloat(bufferedReader.readLine()));
                candy.setSugar(Float.parseFloat(bufferedReader.readLine()));

                if(candy.getId() == id){
                    return candy;
                }

                candy = null;
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        if(candy == null){
            throw new EntityNotFoundException("Not found candy with id = " + id);
        }

        return null;
    }
}
