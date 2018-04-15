package com.epam.main;

import com.epam.dao.*;
import com.epam.entity.Candy;
import com.epam.exc.EntityNotFoundException;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Factory<Factory> aFactory = new AbstractFactory();
        Factory<FileDAO> fileDAOFactory = aFactory.create("textFileDAO");

        FileDAO<Candy> candyFileDAO = fileDAOFactory.create("candy");
        FileDAO<Candy> chocolateFileDAO = fileDAOFactory.create("chocolate");
        FileDAO<Candy> sweetMeatFileDAO = fileDAOFactory.create("sweatmeat");
        FileDAO<Candy> giftFileDAO = fileDAOFactory.create("gift");

        try{
            Candy candy = candyFileDAO.find(2);
        } catch (EntityNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        try{
            Candy candy = candyFileDAO.find(1);
        } catch (EntityNotFoundException ex){
            System.out.println(ex.getMessage());
        }


    }
}
