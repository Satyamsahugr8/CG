package com.basics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Basic {

    public static void main(String[] args) {
        // System.out.println("Basic LSP Example");
        // Animal animal = new Animal(10, "Lion");

        // Field f = animal.getClass().getDeclaredField("age");
        // f.setAccessible(true);
        // f.set(animal, 5);
        // System.out.println("Field Name: " + f.getName());

        try {
            Animal animal2 = Animal.class.getDeclaredConstructor(int.class, String.class).newInstance(7, "Tiger");
            System.out.println("Animal2 created with reflection : " + animal2);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

}

class Animal {

    private int age;
    private String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal [age=" + age + ", name=" + name + "]";
    }

}