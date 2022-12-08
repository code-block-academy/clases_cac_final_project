package models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Product {
    private int id_producto;
    private String name;
    private float price;
    private float quality;
    private String description;

    public Product(int id_producto, String name, float price, float quality, String description) {
        this.id_producto = id_producto;
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.description = description;
    }
    
    public Map<String, Object> getData(){
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("name", name);
        result.put("description", description);
        return result;
    }
}
