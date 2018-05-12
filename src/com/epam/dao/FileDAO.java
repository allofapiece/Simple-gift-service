package com.epam.dao;

import com.epam.exception.EntityNotFoundException;

public interface FileDAO<T> {
    T find(int id) throws EntityNotFoundException;
}
