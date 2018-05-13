package com.epam.dao;

import com.epam.dao.Impl.GiftFileDAO;
import com.epam.dao.Impl.SweetFileDAO;

/**
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class FileDAOFactory implements Factory {
    /**
     * @param type necessary entity type
     * @return FileDAO
     */
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
