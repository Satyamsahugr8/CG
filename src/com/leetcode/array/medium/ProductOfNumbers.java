package com.leetcode.array.medium;

import java.util.ArrayList;

public class ProductOfNumbers {
	
	ArrayList<Integer> arr;
	ArrayList<Integer> product;
	int count;
	
    public ProductOfNumbers() {
        arr = new ArrayList<Integer>();
        product = new ArrayList<Integer>();
        count = 0;
    }
    
    public void add(int num) {
    	
    	arr.add(num);
    	
    	if ( num == 0 ) {
    		count = 0;
    		product = new ArrayList<Integer>();
    	} else {
    		count++;
    		
	    	if ( count <= 1) {
	    		product.add(num);
	    	}
	        
	    	if (count >= 2) {
	        	product.add(product.get(product.size() - 1) * num);
	        }
	    }
    }
    
    public int getProduct(int k) {    		
    	
    	if ( k > product.size() ) {
    		return 0;
    	}
    	
    	else if ( k < product.size() ) {
    		return product.get(product.size() - 1) / product.get(product.size() - k - 1);
    	}
    	
    	return product.get(product.size() - 1);
    }
    
    public static void main(String[] args) {
		
    	ProductOfNumbers p = new ProductOfNumbers();
    	p.add(3);
    	p.add(2);
    	p.add(5);
    	p.add(4);
    	System.out.println(p.getProduct(4));
	}
}