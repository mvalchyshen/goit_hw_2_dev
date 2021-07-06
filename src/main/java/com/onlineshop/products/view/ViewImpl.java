package com.onlineshop.products.view;

public class ViewImpl implements View {

    public static final String INPUT_PRODUCT_NAME = "Write Product Name";
    public static final String INPUT_PRODUCT_PRICE = "Write Product Price";
    public static final String INPUT_PRODUCT_SALE_PRICE = "Write Product Sale Price";
    public static final String INPUT_PRODUCT_SALE_QUANTITY = "Write Product Sale Quantity";

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printResult(String products, int totalCost) {
        System.out.println("Total cost for:" + products + " is = " + totalCost);
    }
}
