package com.basics;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.adaptJavaQues.personalhealth.main;

public class StreamsQuestions {
    
    public static void main(String[] args) {

        StreamsQuestions sq = new StreamsQuestions();
        sq.findTheFirstNonRepeatingCharacter();
        sq.groupByEmployeeDepartment();
        

    }

    static class Employee {
        private String name;
        private String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    void groupByEmployeeDepartment() {
        // Group employees by their department
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Charlie", "HR"),
            new Employee("David", "Finance")
        );

        Map<String, List<Employee>> groupedByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
        
    }


    void findTheFirstNonRepeatingCharacter() {
        // Find the first non-repeating character in a string
        String s = "aabbcdd";

        Character ch = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .get();

        System.out.println(ch);

        IntStream n = s.chars();
        n.forEach(System.out::println);
    }
}

