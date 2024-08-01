package org.example;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Product> {
    public int compare(Product a, Product b){
        return a.quantity-b.quantity;
    }
}
