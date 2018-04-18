package com.epam.controller;

import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.service.GiftService;
import com.epam.view.GiftView;
import com.epam.view.SweetView;

import java.util.ArrayList;
import java.util.List;

public class GiftController {
    private GiftService giftService;
    private GiftView giftView;
    private SweetView sweetView;

    public GiftController() {
        /*Dependency injections*/
        this.giftService = new GiftService();
        this.giftView = new GiftView();
        this.sweetView = new SweetView();
    }

    public void begin() {
        float sugarMin = 40;
        float sugarMax = 50;
        List<Sweet> filteredSweets = new ArrayList<>();

        Gift gift = giftService.find(0);
        giftService.sort(gift, "sweetType");
        this.showOne(gift);
        System.out.println("Weight of gift: " + giftService.calculateGiftWeight(gift));
        System.out.println("\nSweet sugar filter with minimal "
                            + sugarMin + " and maximum "
                            + sugarMax + " values");

        filteredSweets.addAll(giftService.sugarFilter(gift, sugarMin, sugarMax));
        this.sweetView.showAll(filteredSweets);
    }

    public void showOne(Gift gift) {
        giftView.showGift(gift);
    }
}
