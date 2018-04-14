package com.epam.dao;

import com.epam.dao.Impl.CandyFileDAO;

public class FileDAOFactory implements Factory {
    public FileDAO create(String type) {
        switch (type) {
            case "candy": return new CandyFileDAO();
            case "chocolate": return new CandyFileDAO();
            case "sweetmeat": return new CandyFileDAO();
            case "gift": return new CandyFileDAO();
            default: return null;
        }
    }
}
