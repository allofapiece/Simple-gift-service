package com.epam.dao;

public interface Factory<T> {
    T create(String type);
}
