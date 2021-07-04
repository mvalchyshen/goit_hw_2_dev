package com.onlineshop.products.view;

public class ViewImpl implements View {

    public static final String INPUT_PRODUCT_NAME = "Write Product Name";

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printResult(String products, int totalCost) {
        System.out.println("Total cost for:" + products + " is = " + totalCost);
    }
}
