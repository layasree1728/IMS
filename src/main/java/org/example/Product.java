package org.example;
import java.lang.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//Step1
public class Product {
    int product_id;
    String name;
    String category;
    Double price;
    int quantity;
    static HashSet<String> categories=new HashSet<>();
    //constructors
    public Product(int product_id,
                   String name,
                   String category,
                   Double price,
                   int quantity){
        this.product_id=product_id;
        this.name=name;
        this.category=category;
        this.price=price;
        this.quantity=quantity;
        categories.add(category);
    }

    //setters to set individual value
    public void setProduct_id(int product_id){
        this.product_id=product_id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    //getter to get individual value

    public int getProduct_id(){
        return product_id;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public Double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }


}
