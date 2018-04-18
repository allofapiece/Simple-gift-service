package com.epam.view;

import com.epam.entity.Gift;
import com.epam.entity.Sweet;

public class GiftView {
    public void showGift(Gift gift) {
        System.out.println("Gift id: " + gift.getId());
        System.out.println("____________content_____________");
        for (Sweet sweet :
                gift.getSweets()) {
            System.out.println("id: " + sweet.getId());
            System.out.print("sweet type: ");
            switch (sweet.getType()) {
                case Chocolate:
                    System.out.println("chocolate");
                    break;

                case Candy:
                    System.out.println("candy");
                    break;

                case Sweetmeat:
                    System.out.println("sweetmeat");
                    break;

                default:
                    System.out.println("other");
                    break;
            }
            System.out.println("sweet name: " + sweet.getName());
            System.out.println("sugar content: " + sweet.getSugar());
            System.out.println("weight: " + sweet.getWeight());
            System.out.println();
        }
    }
}
