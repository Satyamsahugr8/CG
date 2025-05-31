package com.codingninjas.array;

import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValue {

	public static void main(String[] args) {
		
		int [][] grid = {{9,1,7},{8,9,2},{3,4,6}};
		int[] answer = findMissingAndRepeatedValues(grid, grid.length * grid.length);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] findMissingAndRepeatedValues(int[][] nums, int n) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			if (map.containsKey(i)) {
				map.put(i, map.get(1) + 1);
			} 
			else {
				map.put(i, 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {    
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }
		
        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j < nums[i].length; j++) {
        		if (map.containsKey(nums[i][j])) {
                    map.put(nums[i][j], map.get(nums[i][j]) + 1);
                } 
                else {
                    map.put(nums[i][j], 1);
                }
			}  
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {    
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        int a = 0;
        int b = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {    
        	
        	if ( entry.getValue() == 3) {
        		a = entry.getKey();
        	}
        	
        	if (entry.getValue() == 1) {
        		b = entry.getKey();
        	}
        }
		
        return new int[]{a, b};
	}

}
