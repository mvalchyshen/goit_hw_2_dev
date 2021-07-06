package com.onlineshop.products.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidationUtil {
    public static boolean validId(String id) {
        String engAlphabet = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> "" + (char) c)
                .collect(Collectors.joining());
        return engAlphabet.contains(id);
    }

    public static boolean validPrice(Double price) {
        return price >= 0;
    }

    public static boolean validQuantity(Long quantity) {
        return quantity > 0L;
    }
}
