package com.epam.view;

import com.epam.entity.Sweet;

import java.util.List;

public class SweetView {
    public void showAll(List<Sweet> sweets){
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
    }
}
