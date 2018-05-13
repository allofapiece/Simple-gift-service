package com.epam.dao;

import com.epam.exception.EntityNotFoundException;

/**
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public interface FileDAO<T> {
    /**
     *
     * @param id id of necessary entity
     * @return T
     * @throws EntityNotFoundException
     */
    T find(int id) throws EntityNotFoundException;
}
