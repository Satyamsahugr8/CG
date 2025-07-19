package com.hackerank;

/**
 * Main.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 11-Jun-2025
 */
public class Main {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		Product p2 = new Product();
		
		System.out.println(p1);
		System.out.println(p2);
	}
}

interface IProduct {
    void setId(int id);
    int getId();
    void setName(String name);
    String getName();
    void setCategory(String category);
    String getCategory();
    void setPrice(int price);
    int getPrice();
}


class Product implements IProduct {
    
    private int id;
    private String name;
    private String category;
    private int price;
    
//    // Singleton 
//    private static final Product instance = new Product();
//    
//    public static Product getInstance() {
//        if (instance == null ) {
//            return instance;
//        }
//        else return instance;
//    }
//    
//    private Product() {
//        
//    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
}
