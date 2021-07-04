package com.onlineshop.products.view;

public class ViewImpl implements View {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printResult(String products, int totalCost) {
        System.out.println("Total cost for:" + products + " is = " + totalCost);
    }
}
