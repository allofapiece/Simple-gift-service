package com.epam.dao;

import com.epam.dao.Impl.GiftFileDAO;
import com.epam.dao.Impl.SweetFileDAO;

public class FileDAOFactory implements Factory {
    public FileDAO create(String type) {
        switch (type) {
            case "sweet":
                return new SweetFileDAO();

            case "gift":
                return new GiftFileDAO();

            default:
                return null;
        }
    }
}
