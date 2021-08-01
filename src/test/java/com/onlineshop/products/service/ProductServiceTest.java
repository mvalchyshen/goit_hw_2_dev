package com.onlineshop.products.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductServiceTest {

    private final double accuracy = 0.0001;
    private ProductServiceImpl productService;

    @BeforeEach
    public void initialize() {
        productService = new ProductServiceImpl();

    }

    @Test
    public void calculateTotalPriceWithCorrectBucket() {
        calculateTotalPrice(13.25,"ABCDABA");
    }

    @Test
    public void calculateWithEmptyBucket() {
        calculateTotalPrice(0.0," ");
    }

    @Test
    public void calculateWithNotExistingProduct() {
        calculateTotalPrice(13.25, "ABCDABAFFFFFFFFFFF");
    }

    @Test
    public void calcualteWithNotNumberInBucket() {
        calculateTotalPrice(13.25, "ABCDABA2222222222");
    }
    @Test
    public void calculateTotalPriceIfBucketIsNull() {
        assertThrows(NullPointerException.class,() ->productService.calculateTotalPrice(null));
    }

    private void calculateTotalPrice(Double expect, String products) {
        assertEquals(expect,productService.calculateTotalPrice(products));
    }

}
