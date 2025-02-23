package com.tufplus.binarysearch.fundamentals;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {-1,20,3,5,22,9,12};
		int search = 9;
		
//		int result = search(arr, search);
//		System.out.println(result);
		
		int result = lowerBound(arr, search);
//		System.out.println(result);
		
		int[] arr4 = {3, 4, 4, 7, 8, 10};
		int[] re = getFloorAndCeil(arr4, 5);
		
//		for (int i : re) {
//			System.out.print(i + " ");
//		}
		
		
//		int[] nums1 = {1, 3, 5, 6};
//		int target = 0;
//		System.out.println(searchInsert(nums1, target));
		
		int[] nums3 = {5, 7, 7, 8, 8, 10};
		int target = 8;
		 
		for (int i : searchRange(nums3, target)) {
			System.out.print(i + " ");
		}	

	}
	
	public static int[] searchRange(int[] nums, int target) {
        
        int[] ans = {-1, -1};
        
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
			
        	if ( target == nums[i]) {
        		ans[j] = i;
        		j++;
        	}
		}
		return ans;
     }
		
	public static int[] getFloorAndCeil(int[] nums, int x) {
		
		return new int[] {Solution.getFloor(nums, x), Solution.getCeil(nums, x)};
        
    }

	private static int getFloor(int[] nums, int x) {
		
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		
		while( low <= high ) {
			
			int mid = (low + high) / 2 ;
			
			if ( nums[mid] <= x ) {
				ans = nums[mid];
				low = mid + 1;
			}
			
			else {
                high = mid - 1;
            }
			
		}
		
		return ans;
	}

	private static int getCeil(int[] nums, int x) {
		
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		
		
		
		while( low <= high ) {
			
			int mid = (low + high) / 2 ;
			
			if ( nums[mid] >= x ) {
				ans = nums[mid];
				high = mid - 1;
			}
			
			else {
				low = mid + 1;
            }
			
		}
		
		
		return ans;
		
	}
	
	public static int searchInsert(int[] nums, int target) {
		
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		
		while( low <= high ) {
			
			int  mid = ( low + high )/2;
			
			if( low == (nums.length - 1) ) {
				ans = nums.length;
			}
			
			if ( nums[mid] >= target ) {
				ans = mid;
				high = mid - 1;
			}
			
			else {
				low = mid + 1;
			}
			
		}
		
		
		return ans;
    }
	
//	public static int searchInsert(int[] nums, int target) {
//        // Iterate through the array
//        for (int i = 0; i < nums.length; i++) {
//            /* If current element is greater than 
//                 or equal to the target */
//            if (nums[i] >= target) {
//                // Return the current index
//                return i;
//            }
//        }
//        /* If target is greater than all elements, 
//             return the length of the array */
//        return nums.length;
//    }
	
	public static int search(int[] nums, int target) {
	       
		int index = 0;
		for (int i : nums) {
			
			if ( target == i) {
				return index;
			}
			
			index++;
			
		}
		return -1;
    }

	public static int lowerBound(int[] nums, int x) {
		
		int index = 0;
		for (int i : nums) {
			
			if ( i >= x) {
				return index;
			}
			
			index++;
			
		}
		return -1; 
    }
}
