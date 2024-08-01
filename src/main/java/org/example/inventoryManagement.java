package org.example;

import java.util.*;

public class inventoryManagement {
    //Step 2  Implement Methods for Adding, Removing, Listing, Updating, and Searching Products
    //Adding product information
    static HashSet<String> categories=new HashSet<>();
    static TreeMap<Integer,Product> inventoryMap=new TreeMap<>();
    //Updating Products or adding product information
    // both methods are implemented in one code


    public static void add_or_updateProduct(Product newProduct){
        int product_id=newProduct.getProduct_id();
        if(inventoryMap.containsKey(product_id)){
            inventoryMap.put(product_id,newProduct);
        }
        else{
            inventoryMap.put(newProduct.getProduct_id(),newProduct);
            categories.add(newProduct.getCategory());
        }
    }

    // removing product info
    public static void removeProduct(int product_id) {
        if(inventoryMap.containsKey(product_id)){
            inventoryMap.remove(product_id);
        }
        else{
            System.out.println("No Such Product exist");
        }
    }
    // Listing products

    public static ArrayList<Product> listingProduct(){
        return new ArrayList<>(inventoryMap.values());
    }
    //searching for products
    public static Product searchProduct(int product_id){
        return ProductUtility.search(inventoryMap,product_id);

    }
    // Get all unique categories
    public static Set<String> getCategories() {
        return categories;
    }

    // Sorting Products
    public static void setSorting(Comparator<Product> comparator) {
        List<Product> sortedProducts = ProductUtility.sorting(inventoryMap, comparator);
        TreeMap<Integer, Product> sortedMap = new TreeMap<>();
        for (Product product : sortedProducts) {
            sortedMap.put(product.getProduct_id(), product);
        }
        inventoryMap = sortedMap;
    }
}
