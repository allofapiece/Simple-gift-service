package com.epam.view;

import com.epam.entity.Gift;
import com.epam.entity.Sweet;

public class GiftView {
    public void showGift(Gift gift) {
        SweetView sweetView = new SweetView();

        System.out.println("Gift id: " + gift.getId());
        System.out.println("____________content_____________");
        sweetView.showAll(gift.getSweets());
    }
}
