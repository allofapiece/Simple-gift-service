package com.epam.dao;

import com.epam.exc.EntityNotFoundException;

import java.util.List;

public interface FileDAO<T> {
    List findAll();

    T find(int id) throws EntityNotFoundException;
}
