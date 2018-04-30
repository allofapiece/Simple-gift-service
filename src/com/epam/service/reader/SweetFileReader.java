package com.epam.service.reader;

import com.epam.entity.Sweet;
import com.epam.entity.SweetType;

import java.io.BufferedReader;
import java.io.IOException;

public class SweetFileReader {
    public Sweet readOne(BufferedReader bufferedReader) {
        Sweet sweet = new Sweet();

        try {
            sweet.setId(Integer.parseInt(bufferedReader.readLine()));
            sweet.setName(bufferedReader.readLine());
            switch (bufferedReader.readLine()) {
                case "chocolate":
                    sweet.setType(SweetType.Chocolate);
                    break;

                case "candy":
                    sweet.setType(SweetType.Candy);
                    break;

                case "sweetmeat":
                    sweet.setType(SweetType.Sweetmeat);
                    break;

                default:
                    sweet.setType(SweetType.Other);
                    break;
            }
            sweet.setWeight(Float.parseFloat(bufferedReader.readLine()));
            sweet.setSugar(Float.parseFloat(bufferedReader.readLine()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sweet;
    }
}
