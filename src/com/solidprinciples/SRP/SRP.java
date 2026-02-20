package com.solidprinciples.SRP;

/**
 * SRP.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 02-Oct-2025
 */
public class SRP {

	public static void main(String[] args) {

	}
}


// not following 

// Here, Report is responsible for report creation, saving, and sending.
// Changes in file handling or email logic would force modification of this class.

// lets suppose i have to make some logic changes in below saving to file method and send email method
// then this will lead us to modify Report class 
// which violate SRP

class Report {
    public void generateReport() {
        // logic to generate report
    }

    public void saveToFile(String filename) {
        // logic to save report to file
    }

    public void sendEmail(String email) {
        // logic to email report
    }
}


// following 

// Now, each class has only one reason to change.
// Report generation, saving, and mailing are independent

class ReportGenerator {
    public void generateReport() {
        // logic to generate report
    }
}

class ReportSaver {
    public void saveToFile(String filename) {
        // logic to save report
    }
}

class ReportMailer {
    public void sendEmail(String email) {
        // logic to send report via email
    }
}


