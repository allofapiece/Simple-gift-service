package com.epam.dao;

public class AbstractFactory implements Factory {
    @Override
    public Factory create(String type) {
        switch (type) {
            case "fileDAO" : return new FileDAOFactory();
            default: return null;
        }
    }
}
