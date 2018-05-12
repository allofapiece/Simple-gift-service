package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;
import com.epam.service.reader.SweetFileReader;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SweetFileDAO implements FileDAO {
    private SweetFileReader sweetFileReader;
    private static final Logger log = Logger.getLogger(SweetFileDAO.class);

    public SweetFileDAO() {
        this.sweetFileReader = new SweetFileReader();
    }

    public Sweet find(int id) throws EntityNotFoundException {
        log.debug("Requested sweet with id = " + id);
        Sweet sweet = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("resource/sweets.txt")));
            while (bufferedReader.ready()) {
                sweet = this.sweetFileReader.readOne(bufferedReader);
                if (sweet.getId() == id) {
                    break;
                }

                sweet = null;
            }
        } catch (IOException ex) {
            log.error("IOException thrown", ex);
        }

        if (sweet == null) {
            throw new EntityNotFoundException("Not found sweet with id = " + id);
        }
        log.debug("Provided sweet with id = " + id);

        return sweet;
    }
}
