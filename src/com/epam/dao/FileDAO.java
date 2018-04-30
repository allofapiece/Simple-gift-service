package com.epam.dao;

import com.epam.exception.EntityNotFoundException;

import java.util.List;

public interface FileDAO<T> {
    List findAll();

    T find(int id) throws EntityNotFoundException;
}
