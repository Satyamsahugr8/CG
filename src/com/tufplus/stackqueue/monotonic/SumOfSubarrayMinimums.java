package com.tufplus.stackqueue.monotonic;

import com.leetcoder.pattern.stack.NextGreaterElement;

/**
 * SumOfSubarrayMinimums.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 18-Sep-2025
 */
public class SumOfSubarrayMinimums {

	public static void main(String[] args) {

		SumOfSubarrayMinimums a = new SumOfSubarrayMinimums();
		int[] arr = {3, 1, 2, 5};
		int ans = a.sumSubarrayMins(arr);
		System.out.println(ans);
	}
	
//	Input: arr = [3, 1, 2, 5]
//			Output: 18
//	The minimum of subarrays: 
//	[3], [1], [2], [5], [3, 1], [1, 2], [2, 5], [3, 1, 2], 
//	[1, 2, 5], [3, 1, 2, 5] 
//	are 3, 1, 2, 5, 1, 1, 2, 1, 1, 1 respectively and their sum is 18.
	
	public int sumSubarrayMins(int[] arr) {
		
		NextGreaterElement n = new NextGreaterElement();
		
		int [] minR = n.nextSmallestElementRightBest(arr);
		int [] miniL = n.nextSmallestElementLeftBest(arr);
		
//		for (int i = 0; i < miniL.length; i++) {
//			System.out.println(minR[i]);
//		}
//		
//		System.out.println();
//		for (int i = 0; i < miniL.length; i++) {
//			System.out.println(miniL[i]);
//		}
		
//		1 4 4 4
//		0 0 1 2
		
		int mod = (int)1e9 + 7; // Mod value
        
        // To store the sum
        int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			int left = i - miniL[i];
			int right = minR[i] - i;
			
			long freq = left * right * 1L;
            
            // Contribution due to current element 
            int val = (int)((freq * arr[i]) % mod);
            
            // Updating the sum
            sum = (sum + val) % mod;
		}
		return sum;
    }
}
