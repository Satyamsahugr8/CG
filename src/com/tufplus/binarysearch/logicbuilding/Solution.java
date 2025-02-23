package com.tufplus.binarysearch.logicbuilding;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	
	
	public static void main(String[] args) {
		int [] arr = {4, 5, 6, 7, 0, 1, 2};
		int s = searchInARotatedArray1(arr, 0);
//		System.out.println(s);
		
		int index = findKRotation((ArrayList<Integer>) Stream.of(4, 5, 6, 7, 0, 1, 2).collect(Collectors.toList()));
//		System.out.println(index);
		
		
		int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
		int r = findSingleElement(nums);
//		System.out.println(r);
		
		
		int[] numss = {8,4,2,3};
        int limit = 10;

        // Create an object of the Solution class
        Solution sol = new Solution();

        int ans = sol.smallestDivisor(numss, limit);

        // Print the result
//        System.out.println("The minimum divisor is: " + ans);
        
        
        int[] arr11 = {25, 46, 28, 49, 24};
        int m = 4;
        
        int ans11 = findPages(arr11, m);

        // Output the result
//        System.out.println("The answer is: " + ans11);
        
        
        
        
        int[] arr3 = {-2, -1, 3, 4, 5};
        
        // Create an instance of the Solution class
        Solution sol3 = new Solution();
        
        int ans3 = sol3.findPeakElement(arr3);
        
        // Output the result
        System.out.println("The peak is at index: " + ans3);
		
		
	}
	
	public static int searchInARotatedArray1(int nums [], int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		
		while( low <= high ) {
			
			int  mid = ( low + high )/2;
			
			if (nums[mid] == target ) {
				return mid;
			}
			
			if(nums[low] <= nums[mid]) {
				
				if(nums[low] <= target && target <= nums[mid] ) {
					high = mid -1;
				} else {
					low = mid +1;
				}
					
			} else  {
				if(nums[mid] <= target && target <= nums[high] ) {
					low = mid +1;
				} else {
					high = mid -1;
				}
				
			}
			
		}
		
		
		return ans;
	}
	
	public static boolean searchInARotatedArray2(ArrayList<Integer> numss, int target) {
		int low = 0;
		Integer[] nums = new Integer[numss.size()];
        nums = numss.toArray(nums);
		int high = nums.length - 1;
		
		while( low <= high ) {
			
			int  mid = ( low + high )/2;
			
			if (nums[mid] == target ) {
				return true;
			}
			
			if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
				low = low + 1;
				high = high -1;
				continue;
			} else {
			
				
				if(nums[low] <= nums[mid]) {
					
					if(nums[low] <= target && target <= nums[mid] ) {
						high = mid -1;
					} else {
						low = mid +1;
					}
						
				} else  {
					
					if(nums[mid] <= target && target <= nums[high] ) {
						low = mid +1;
					} else {
						high = mid -1;
					}
					
				}
			
			}
		}
		return false;
	}
	
	public static int searchMinimum(ArrayList<Integer> numss) {
		int low = 0;
		Integer[] nums = new Integer[numss.size()];
        nums = numss.toArray(nums);
		int high = nums.length - 1;
		
		int min = Integer.MAX_VALUE;
		
		while( low <= high ) {
			
			int  mid = ( low + high )/2;
			
			if ( nums[low] <= nums[mid]) {
				min = Math.min(min, nums[low]);
				low = mid + 1;
			}
			
			else {
				min = nums[mid];
				high = mid - 1;
			} 
			
			
		}
		return min;
	}
	
	public static int findKRotation(ArrayList<Integer> numss) {
    	
		Integer[] nums = new Integer[numss.size()];
        nums = numss.toArray(nums);
        int low = 0;
        int high = nums.length - 1;
		int index = 0;
		int ans = nums[index];
		
		// 4, 5, 6, 7, 0, 1, 2
		while( low <= high ) {
			
			int  mid = ( low + high )/2;

			if ( nums[low] <= nums[mid] ) {
				ans = nums[low];
				index = low;
				low = mid +1;
			}
			
			else {
				ans = nums[mid];
				index = mid;
				high = mid - 1;
			}

		}
		
		return index;
    }
	
	public static int findSingleElement(int[] nums) {
		
		int n = nums.length;
		if ( n == 1 ) {
			return nums[0];
		}
		
		if ( nums[0] != nums[1]) return nums[0];
		if ( nums[n-1] != nums[n-2] ) return nums[n-1];
		
		int low = 1;
		int high = n - 2;
		
		while( low <= high ) {
			
			int  mid = ( low + high )/2;
			
			if ( nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
				return nums[mid];
			}
			
			if (( mid %2 == 1 && nums[mid -1] == nums[mid])
					 || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
				low = mid +1;
			} else {
				high = mid -1;
			}
			
		}
		
		return -1;
	}
	
	public int smallestDivisor(int[] nums, int limit) {
        
		int n = nums.length;
        if (n > limit) return -1;
        
		int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        
        int low = 1, high = maxi;

        while ( low <= high ) {

            int mid =(low+high)/2;
            double value = Solution.round(nums, mid);

            if (value <= limit ) {
                high = (mid - 1);
            }
            else {
                low = mid + 1;
            }

        }
        return low;

    }

    public static int round(int[] nums, int mid) {
        int s = 0;
        for (int i: nums) {
            s += Math.round(i/mid);
        }

        return s;
    }

    public static int findPages(int[] nums, int m) {
        int n = nums.length;
        int sum =0;
        if (n<m) return -1;

        for ( int i = n-1; i>0; i--) {
            m--;
            if ( m == 1 ) {
                for(int j = i; j>=0; j--) {
                    sum += nums[j];
                }
                break;
            }
        }

        return sum;
    }

    public static int findPeakElement(int[] arr) {
    	
    	int n = arr.length;
    	
    	if ( n == 1 ) return 0;
    	
    	for (int i = 0; i<n; i++) {
    		
    		if ( i ==0 && arr[i] > arr[i+1]) {
    			return 0;
    		}
    		
    		if (i == n-1 && arr[n-2]< arr[n-1]) {
    			return n-1;
    		}
    		
    		if ( i > 0 && i < n-1 && arr[i-1]<arr[i] && arr[i]>arr[i+1]) {
    			return i;
    		}
    		
    	}
    	return -1;
    }
}
