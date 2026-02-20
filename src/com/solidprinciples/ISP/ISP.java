package com.solidprinciples.ISP;

/**
 * ISP.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 02-Oct-2025
 */
public class ISP {

	public static void main(String[] args) {

	}
}

// not following
// Robot is forced to implement eat(), which it doesn’t need.

interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
    	System.out.println("Robot works");
    }
    
    public void eat() { 
        // Robots don’t eat!
        throw new UnsupportedOperationException("Robots don't eat"); 
    }
}


	
// following

// Now classes implement only what they need.
// No unnecessary methods.

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    
	public void work() { 
    	System.out.println("Human works");
    }
    
    public void eat() { 
    	System.out.println("Human eats");
    }
}

class Robot2 implements Workable {
    
	public void work() { 
    	System.out.println("Robot works");
    }
}

