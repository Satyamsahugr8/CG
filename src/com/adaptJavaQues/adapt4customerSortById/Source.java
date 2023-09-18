package com.adaptJavaQues.adapt4customerSortById;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Source {

    public static List<Customer> sortByCustomerId(List<Customer> l) {
        return l.stream().sorted(Comparator.comparing(Customer::getCustomerId))
                .collect(Collectors.toList());
    }

    public static List<Customer> sortByCustomerName(List<Customer> l) {
        return l.stream().sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Customer cs1 = new Customer(1,"Avinash","lamakheda");
        Customer cs2 = new Customer(4,"Satyam","bhopal");
        Customer cs3 = new Customer(5,"Ritik","lamakheda");
        Customer cs4 = new Customer(3,"Rudresh","lamakheda");

        List<Customer> customers = Arrays.asList(cs1, cs2, cs3,cs4);
        System.out.println(sortByCustomerId(customers));
        System.out.println("------------------------------");
        System.out.println(sortByCustomerName(customers));


    }
}
