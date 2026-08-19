package com.codingninjas.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingUsingMap {
	
	// Driver code
    public static void main(String args[]) {
    	
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        countFreq(arr, n);
    }
	
	public static void countFreq(int arr[], int n) {
        
		Map<Integer, Integer> map = new HashMap<>();
		
        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < n; i++) {
        	
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } 
            else {
                map.put(arr[i], 1);
            }
            
        }
        
        // Traverse through map and print frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {    
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // more ways to traverse through map
        for ( Integer key : map.keySet()) {
        	System.out.println(key + " " + map.get(key));
        }

        // more ways to traverse through map
        for ( Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // more ways to traverse through map
        map.forEach((key, value) -> System.out.println(key + " " + value));

        // Iterable
        Iterable<Map.Entry<Integer, Integer>> iterable = map.entrySet();
        for ( Map.Entry<Integer, Integer> entry : iterable) {
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // use of map.putIfAbsent(null, null);
        map.putIfAbsent(20, 5);
        System.out.println(map.get(20));

    }
 
    
    
}
