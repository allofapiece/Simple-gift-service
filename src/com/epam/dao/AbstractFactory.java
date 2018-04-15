package com.epam.dao;

public class AbstractFactory implements Factory {
    @Override
    public Factory create(String type) {
        switch (type) {
            case "textFileDAO" : return new FileDAOFactory();
            default: return null;
        }
    }
}
