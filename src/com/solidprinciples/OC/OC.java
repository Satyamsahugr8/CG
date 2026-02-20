package com.solidprinciples.OC;

/**
 * OC.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 02-Oct-2025
 */
public class OC {

	public static void main(String[] args) {

	}
}

// not following

// new shape (Triangle, Square), we must modify AreaCalculator.

class AreaCalculator {
	
    public double calculate(Object shape) {
        
    	if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return 3.14 * c.radius * c.radius;
        } 
    	
    	else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.length * r.breadth;
        }
    	
        return 0;
    }
    
}

// following

// Adding new shapes does’ant require changing AreaCalculator.
// Just implement Shape.

interface Shape {
    double area();
}

class Circle2 implements Shape {
    
	double radius;
    
	Circle2(double r) { 
    	this.radius = r; 
    }
    
    public double area() { 
    	return 3.14 * radius * radius;
    }
    
}

class Rectangle2 implements Shape {
    
	double length, breadth;
    
	Rectangle2(double l, double b) { 
		this.length = l;
		this.breadth = b;
	}
    
	public double area() {
		return length * breadth;
    }
}

class AreaCalculator2 {

	public double calculate(Shape shape) {
        return shape.area();
    }
    
}







