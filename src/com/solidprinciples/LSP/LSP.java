package com.solidprinciples.LSP;

/**
 * LSP.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 02-Oct-2025
 */
public class LSP {

	public static void main(String[] args) {
		
		
	}
}

// not following

// Ostrich breaks substitution — if we use Ostrich in place of Bird, code breaks.

class Bird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
	
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly!");
	}

}


// following

// Bird has only common behavior (eat).
// Flying is separated into Flyable.
// Now, substitution works fine.

interface Bird2 {
    void eat();
}

interface Flyable {
    void fly();
}

class Sparrow implements Bird2, Flyable {

    @Override
	public void eat() {
    	System.out.println("Sparrow eats");
    }

    @Override
    public void fly() {
    	System.out.println("Sparrow flies");
    }
}

class Ostrich2 implements Bird2 {

    @Override
	public void eat() {
    	System.out.println("Ostrich eats");
    }

}









