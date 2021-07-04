package com.onlineshop.products.view;

public interface View {
    void printMessage(String message);
    void printResult(String products, int totalCost);
    static View of() {
        return new ViewImpl();
    }
}
