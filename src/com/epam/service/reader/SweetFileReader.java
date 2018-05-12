package com.epam.service.reader;

import com.epam.entity.Sweet;
import com.epam.entity.SweetType;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class SweetFileReader {
    private static final Logger log = Logger.getLogger(SweetFileReader.class);

    public Sweet readOne(BufferedReader bufferedReader) {
        Sweet sweet = new Sweet();

        try {
            sweet.setId(Integer.parseInt(bufferedReader.readLine()));
            sweet.setName(bufferedReader.readLine());
            switch (bufferedReader.readLine()) {
                case "chocolate":
                    sweet.setType(SweetType.CHOCOLATE);
                    break;

                case "candy":
                    sweet.setType(SweetType.CANDY);
                    break;

                case "sweetmeat":
                    sweet.setType(SweetType.SWEETMEAT);
                    break;

                default:
                    sweet.setType(SweetType.OTHER);
                    break;
            }
            sweet.setWeight(Float.parseFloat(bufferedReader.readLine()));
            sweet.setSugar(Float.parseFloat(bufferedReader.readLine()));
        } catch (IOException ex) {
            log.error("IOException thrown", ex);
        }

        return sweet;
    }
}
