package com.epam.controller;

import com.epam.entity.Gift;
import com.epam.service.GiftService;
import com.epam.view.GiftView;

public class GiftController {
    private GiftService giftService;
    private GiftView giftView;

    public GiftController() {
        /*Dependency injections*/
        this.giftService = new GiftService();
        this.giftView = new GiftView();
    }

    public void begin() {
        Gift gift = giftService.find(0);
        giftService.sort(gift, "sweetType");
        this.showOne(gift);
        System.out.println("Weight of gift" + giftService.calculateGiftWeight(gift));
    }

    public void showOne(Gift gift) {
        giftView.showGift(gift);
    }
}
