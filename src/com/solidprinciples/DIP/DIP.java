package com.solidprinciples.DIP;

/**
 * DIP.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 02-Oct-2025
 */
public class DIP {

	public static void main(String[] args) {
        System.out.println("satyam");
	}
}

// not following

class MySQLDatabase {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class UserService {
    private MySQLDatabase db = new MySQLDatabase();

    public void getUser() {
        db.connect();
        System.out.println("Get user from DB");
    }
}


// following

interface Database {
    void connect();
}

class MySQLDatabase2 implements Database {
    public void connect() { System.out.println("Connected to MySQL"); }
}

class PostgresDatabase implements Database {
    public void connect() { System.out.println("Connected to Postgres"); }
}

class UserService2 {
    private Database db;

    public UserService2(Database db) {
        this.db = db; // Dependency injection
    }

    public void getUser() {
        db.connect();
        System.out.println("Get user from DB");
    }
}

