package org.example;

import java.util.Comparator;

public class IdComparator implements Comparator<Product> {
    public int compare(Product a,Product b){
        return a.product_id-b.product_id;
    }
}
