package com.onlineshop.products.util;

public interface Validation<Q, P> {
    boolean validSaleQuantity(Q quantity);
    boolean validPrice(P price);

}
