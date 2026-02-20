package com.amazon;

import java.math.BigInteger;
import java.util.*;

public class TransactionLogs {

    /**
     * Process logs and return sorted list of userIds whose involvement count >= threshold.
     *
     * @param logs      array of log strings, each like "sender recipient amount"
     * @param threshold integer threshold
     * @return sorted List<String> of userIds that meet or exceed threshold
     */
    public static List<String> processLogs(String[] logs, int threshold) {
        Map<String, Integer> count = new HashMap<>();

        for (String log : logs) {
            if (log == null || log.trim().isEmpty()) continue;
            String[] parts = log.trim().split("\\s+");
            if (parts.length < 2) continue; // malformed line guard

            String sender = parts[0];
            String recipient = parts[1];

            // each unique user in this transaction should get +1 (if sender==recipient only once)
            Set<String> participants = new HashSet<>();
            participants.add(sender);
            participants.add(recipient);

            for (String user : participants) {
                count.put(user, count.getOrDefault(user, 0) + 1);
            }
        }

        List<String> flagged = new ArrayList<>();
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (e.getValue() >= threshold) flagged.add(e.getKey());
        }

        // Sort by numeric value (so "029323" stays as that string but sorts based on numeric value)
        Collections.sort(flagged, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // use BigInteger to avoid overflow and handle large ids
                BigInteger A = new BigInteger(a);
                BigInteger B = new BigInteger(b);
                int cmp = A.compareTo(B);
                if (cmp != 0) return cmp;
                return a.compareTo(b); // tie-breaker (unlikely) preserve lexicographic
            }
        });

        return flagged;
    }

    // Demo with the example from the problem statement
    public static void main(String[] args) {
        String[] logs = new String[] {
            "345366 89921 45",
            "029323 38239 23",
            "38239 345366 15",
            "029323 38239 77",
            "345366 38239 23",
            "029323 345366 13",
            "38239 38239 23"
        };
        int threshold = 3;
        List<String> res = processLogs(logs, threshold);
        System.out.println(res); // printed result
    }
}
