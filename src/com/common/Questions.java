package com.common;

import java.util.HashMap;
import java.util.Map;

public class Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(decimalToHexaDecimal(721));
		
		int[] nums = {6,10,6};
		boolean b = check(nums);
		System.out.println(b);
	}

	public static String decimalToHexaDecimal(int n) {

		String str = "";
		if (n > 0 && n <= 15) {
			if (n <= 9) {
				return n + "";
			}
			if (10 == n) {
				return "a";
			}
			if (11 == n) {
				return "b";
			}
			if (12 == n) {
				return "c";
			}
			if (13 == n) {
				return "d";
			}
			if (14 == n) {
				return "e";
			}
			if (15 == n) {
				return "f";
			}
		}

		while (n >= 16) {

			int rem = n % 16;

			if (rem >= 0 && rem <= 15) {
				if (rem <= 9) {
					str = rem + str;
				}
				if (10 == rem) {
					str = "a" + str;
				}
				if (11 == rem) {
					str = "b" + str;
				}
				if (12 == rem) {
					str = "c" + str;
				}
				if (13 == rem) {
					str = "d" + str;
				}
				if (14 == rem) {
					str = "e" + str;
				}
				if (15 == rem) {
					str = "f" + str;
				}
			}

			n = n / 16;
		}

		if (n > 0 && n <= 15) {
			if (n <= 9) {
				str = n + str;
			}
			if (10 == n) {
				str = "a" + str;
			}
			if (11 == n) {
				str = "b" + str;
			}
			if (12 == n) {
				str = "c" + str;
			}
			if (13 == n) {
				str = "d" + str;
			}
			if (14 == n) {
				str = "e" + str;
			}
			if (15 == n) {
				str = "f" + str;
			}
		}

		return str;
	}

	private static char getVal(int n) {
		Map<Integer, Character> map = new HashMap<>();
		{
			map.put(0, '0');
			map.put(1, '1');
			map.put(2, '2');
			map.put(3, '3');
			map.put(4, '4');
			map.put(5, '5');
			map.put(6, '6');
			map.put(7, '7');
			map.put(8, '8');
			map.put(9, '9');
			map.put(10, 'a');
			map.put(11, 'b');
			map.put(12, 'c');
			map.put(13, 'd');
			map.put(14, 'e');
			map.put(15, 'f');
		}

		return map.get(n);
	}

	public String toHex(int num) {
		
		if (num < 0) return Integer.toHexString(num);
		
		StringBuilder res = new StringBuilder();
		
		if (num == 0) return "0";
		
		while (num > 0) {
			int rem = num % 16;
			res.insert(0, getVal(rem));
			num /= 16;
		}
		
		return res.toString();
		
	}

	public static int findMinIndex(int[] arr) {
        
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static boolean check(int[] nums) {

        boolean b = checkSorted(nums, 0);

        if ( b ) {
            return b;
        }

        // else

        int min = findMinIndex(nums);
        int n = nums.length;
        int[] arr = new int[n];
        int j = 0;
        int minn = min;
        System.out.println(min);

        // copying
       while( min < n )  {
            arr[j] = nums[min];
            min++;
            j++;
        }

        for ( int i = 0 ; i < minn ; i++ )  {
            arr[j] = nums[i];
            j++;
        }

        return checkSorted(arr, 0);
    }

    public static boolean checkSorted(int[] arr, int i) {

        //base condition
        if (arr.length <= 1 || i== arr.length-1) {
            return true;
        }

        //calculation
        if (arr[i+1]<arr[i]) {
            return false;
        }

        //smaller case
        return checkSorted(arr, i+1);
    }
    
}
