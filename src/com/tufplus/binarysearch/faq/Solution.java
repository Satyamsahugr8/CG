package com.tufplus.binarysearch.faq;
class Solution {
	
	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5};
        int k = 2;

        // Create an instance of the Solution class
        Solution sol = new Solution();

        int ans = sol.largestSubarraySumMinimized(a, k);

        // Print the answer
        System.out.println("The answer is: " + ans);
		
	}
	
    public int largestSubarraySumMinimized(int[] a, int k) {
    	
    	int n = a.length;
    	
    	if ( n < k ) return -1;
    	if ( n == k ) {
    		int max = a[0];
    		for (int i : a) {
				max = Math.max(i, max);
			}
    		return max;
    	}
    	
    	int mainMin = Integer.MAX_VALUE;
    	
    	
    	for (int i = 0; i <= n-k; i++) {
    		int sum = 0;
    		int j = i;
    		int maxlimit = j + k;
    		
    		while ( j < maxlimit ) {
    			sum += a[j];
    			j++;
    		}
    		
    		mainMin = Math.min(mainMin, sum);
		}    	
 
		return mainMin;
    }
}
