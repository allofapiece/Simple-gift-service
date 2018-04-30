package com.epam.dao.Impl;

import com.epam.dao.FileDAO;
import com.epam.entity.Sweet;
import com.epam.exception.EntityNotFoundException;
import com.epam.service.reader.SweetFileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SweetFileDAO implements FileDAO {
    private SweetFileReader sweetFileReader;

    public SweetFileDAO() {
        /*Dependency injection*/
        this.sweetFileReader = new SweetFileReader();
    }

    @Override
    public List<Sweet> findAll() {
        List<Sweet> sweets = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("resource/sweets.txt")));
            Sweet sweet;
            while (bufferedReader.ready()) {
                sweet = this.sweetFileReader.readOne(bufferedReader);
                sweets.add(sweet);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sweets;
    }

    public Sweet find(int id) throws EntityNotFoundException {
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
            ex.printStackTrace();
        }

        if (sweet == null) {
            throw new EntityNotFoundException("Not found sweet with id = " + id);
        }

        return sweet;
    }
}
