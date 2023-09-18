package com.adaptJavaQues.adapt2userGetByCity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Source {
    public static void main(String[] args) {


    User user1 = new User(1,"amitsahu@gmail.com","amitsahu@123","amit","sahu","bangalore","male",94071);
    User user2 = new User(2,"sonusahu@gmail.com","sonusahu@123","sonu","sahu","kolkata","male",94072);
    User user3 = new User(3,"satyamsahu@gmail.com","satyamsahu@123","satyam","sahu","mumbai","male",94075);

    List<User> users = Arrays.asList(user1, user2, user3);

    List<User> getBangaloreUsers = users.stream()
            .filter(s -> s.getCity().equalsIgnoreCase("Bangalore"))
            .collect(Collectors.toList());

        System.out.println(getBangaloreUsers);

        List<User> getKolkataUsers = users.stream()
                .filter(s -> s.getCity().equalsIgnoreCase("Kolkata"))
                .collect(Collectors.toList());

        System.out.println(getKolkataUsers);

    }
}



