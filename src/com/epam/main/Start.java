package com.epam.main;

import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.service.GiftService;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        GiftService giftService = new GiftService();
        float sugarMin = 40;
        float sugarMax = 50;
        List<Sweet> filteredSweets = new ArrayList<>();

        Gift gift = giftService.find(0);
        giftService.sort(gift, "sweetType"); //Gift sort
        showGift(gift);
        System.out.println("Weight of gift: " + giftService.calculateGiftWeight(gift)); //Gift weight calculating

        System.out.println("\nSweet sugar filter with minimal "
                + sugarMin + " and maximum "
                + sugarMax + " values");
        filteredSweets.addAll(giftService.sugarFilter(gift, sugarMin, sugarMax)); //Search with criteria
        showSweets(filteredSweets);
    }

    public static void showSweets(List<Sweet> sweets){
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
    }

    public static void showGift(Gift gift) {
        System.out.println("Gift id: " + gift.getId());
        System.out.println("____________content_____________");
        showSweets(gift.getSweets());
    }
}
