package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GiftFileDAO implements FileDAO {
    private static final Logger log = Logger.getLogger(GiftFileDAO.class);

    @Override
    public Gift find(int id) throws EntityNotFoundException {
        log.debug("Requested gift with id = " + id);
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

                    log.debug("Provided gift with id = " + id);
                    return gift;
                }

                gift = null;
            }
        } catch (IOException ex) {
            log.error("IOException thrown", ex);
        }

        if (gift == null) {
            throw new EntityNotFoundException("Not found gift with id = " + id);
        }

        return gift;
    }
}
