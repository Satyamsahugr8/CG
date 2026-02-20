package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionLogsAmazon {

    public static void main(String[] args) {
        
        List<String> input = Arrays.asList("1 2 50", "1 7 70", "1 3 20", "2 2 17");
        int threshold = 2;
        System.out.println(input);
        List<String> answer = processLogs(input, threshold);
        System.out.println(answer);

    }
    
    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> userCount = new HashMap<>();
        
        for (String log : logs) {
            String[] parts = log.split(" ");
            String sender = parts[0];
            String recipient = parts[1];
            
            userCount.put(sender, userCount.getOrDefault(sender, 0) + 1);
            if (!sender.equals(recipient)) {
                userCount.put(recipient, userCount.getOrDefault(recipient, 0) + 1);
            }

        }

        userCount.forEach((userId, count) -> {
            // You can add any additional processing logic here if needed
            System.out.println("userId: " + userId + ", count: " + count);
        });
        
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : userCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }
        
        // Sort numerically as strings (since IDs are numeric strings)
        result.sort((a, b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
        
        return result;
    }
}