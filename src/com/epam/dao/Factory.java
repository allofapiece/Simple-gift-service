package com.epam.dao;

/**
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public interface Factory<T> {
    /**
     * @param type
     * @return T
     */
    T create(String type);
}
