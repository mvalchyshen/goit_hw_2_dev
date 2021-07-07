package com.onlineshop.products;

import com.onlineshop.products.model.Product;
import com.onlineshop.products.service.ProductService;
import com.onlineshop.products.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        ProductService service = ProductService.of();
        Product a = service.createNewProduct("A", 1.25, 3l, 3.0);
        Product b = service.createNewProduct("B", 4.25);
        Product c = service.createNewProduct("C", 1.0, 6l, 5.0);
        Product d = service.createNewProduct("D", 0.75);
        service.saveProducts(a,b,c,d);
        System.out.println(service.calculateTotalCost("ABCDABAF"));
    }
}
