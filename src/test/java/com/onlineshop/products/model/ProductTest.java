package com.onlineshop.products.model;

import com.onlineshop.products.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    private final double accuracy = 0.0001;
    private Product product;

    @BeforeEach
    public void initialize() {
        product = new Product("A",2.22,4L,5.25);
    }

    @Test
    public void pricePerEach() {
        assertEquals(5.25,product.pricePerEach(4L),accuracy);
    }

    @Test
    public void priceForEach() {
        assertThrows(NullPointerException.class,() -> product.pricePerEach(null));
    }
}
