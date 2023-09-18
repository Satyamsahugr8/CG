package com.adaptJavaQues.adapt5ProductSortedWrtPrice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        // Adding Products
        Product p1 = new Product(1, "HP Laptop", 25000);
        Product p2 = new Product(2, "Dell Laptop", 30000);
        Product p3 = new Product(3, "Lenevo Laptop", 28000);
        Product p4 = new Product(4, "Sony Laptop", 28000);
        Product p5 = new Product(5, "Apple Laptop", 90000);

        List<Product> productsList = Arrays.asList(p1, p2, p3, p4, p5);
        System.out.println(productsList);
        System.out.println();

        // This is more compact approach for filtering data
        productsList.stream().filter(product -> product.getPrice() == 30000)
                .forEach(product -> System.out.println(product.getPrice()));

        // picking with price 30000
        List<Integer> pst = productsList.stream().filter(product -> product.getPrice() == 30000)
                .map(product -> product.getPrice())
                .collect(Collectors.toList());

        System.out.println(pst);


        //sorting wrt to price
        List<Product> pst2 = productsList.stream()
                .map(product -> product)
                .sorted((o1, o2) -> o1.getPrice()-o2.getPrice()) // For customised comparing We use Comparator compare interface
                .collect(Collectors.toList());

        System.out.println(pst2);

    }
}
