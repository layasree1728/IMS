package org.example;
import java.util.*;
import org.example.Product;
public class ProductUtility {

    //using generics for adding or updating
    public static<K,V> void add_or_update(TreeMap<K,V> map,K key,V value){
        map.put(key, value);
    }

    //using generics for removing

    public static<K,V> void remove(TreeMap<K,V> map,K key){
        map.remove(key);
    }

    // using generics for listing
    public static<K,V> List<V> listing(TreeMap<K,V> map){
        List<V> vs=new ArrayList<>(map.values());
        return vs;
    }
    //using generics for searching

    public static<K,V> V search(TreeMap<K,V> map,K key){
        return map.get(key);
    }
    // using generics for sorting

    public static <K,V> List<V> sorting(TreeMap<K,V> map,Comparator<V> com){
        List<V> valuesList = new ArrayList<>(map.values());
        valuesList.sort(com);
        return valuesList;
    }
}
