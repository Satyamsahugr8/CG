package com.codingninjas.resursion;

import java.util.ArrayList;

public class PepcodingRecursion {

	public static void main(String[] args) {
		
		//1
		ArrayList<ArrayList<Integer>> arrayList = towerOfHanoi(3);
		
		for (ArrayList<Integer> a : arrayList) {
			for (Integer arrayList2 : a) {
				System.out.print(arrayList2 + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//2
		int[] arr = {5,2,4,4,6,6,7,5,54,3,23,5,1,2,3,4,5,5,7};
		int first = firstIndexOfX(arr, 5, 0);
		System.out.println("first : " + first);
		int last = lastIndexOfX(arr, 5, 1);
		System.out.println("last : " + last);
		
		//optimized last index problem
		//start from last index towards zero
		int lastop = lastIndexOfXOptimized(arr, 5, arr.length-1);
		System.out.println("last : " + lastop);
		System.out.println();
		
		
		int[] arrrr = {3,1,2,3,5,6,3,9,3};
		int[] allIndexArr = allIndexOfX(arrrr, 0, 3, 0);
		for (int i : allIndexArr) {
			System.out.print(i + " ");
		}
		
		//3
		//sequences
		
		
	}
	
	public static ArrayList<String> stairCaseBestReturn(int r) {
		
		if ( r < 0 ) {
			ArrayList<String> ans = new ArrayList<String>();
			return ans;
		}
		
		if ( r == 0 ) {
			ArrayList<String> ans = new ArrayList<String>();
			ans.add("");
			return ans;
		}
		
		ArrayList<String> way1 = stairCaseBestReturn(r-1);
		ArrayList<String> way2 = stairCaseBestReturn(r-2);
		ArrayList<String> way3 = stairCaseBestReturn(r-3);
		
		ArrayList<String> ans = new ArrayList<String>();
		
		for (String string : way1) {
			ans.add(1 + string);
		}
		
		for (String string : way2) {
			ans.add(2 + string);
		}
		
		for (String string : way3) {
			ans.add(3 + string);
		}

		return ans;
	}

	private static int[] allIndexOfX(int[] arr, int si, int elem, int fnf) {
		
		if ( arr.length == 0 ) {
			return null;
		}
		
		if ( si == arr.length ) {
			return new int[fnf];
		}
		
		int temp = fnf;
		if ( arr[si] == elem ) {
			fnf++;
		}
		
		//small call
		int[] small = allIndexOfX(arr, si+1, elem, fnf);
		
		if ( arr[si] == elem ) {
			small[temp] = si;
		}
		
		return small;
	}

	private static int lastIndexOfX(int[] arr, int i, int si) {

		if ( arr.length == 0 ) {
			return -1;
		}
		
		if ( si == arr.length ) {
			return -1;
		}
		
		int small = lastIndexOfX(arr, i, si + 1);
		if ( small == -1 ) {
			if ( arr[si] == i) return si;
			else return -1;
		}
		return small;
	}
	
	private static int lastIndexOfXOptimized(int[] arr, int elem, int si) {
		
		if ( arr.length == 0 ) {
			return -1;
		}
		
		if( si < 0 ) {
			return -1;
		}
		
		if ( arr[si] == elem ) {
			return si;
		}
		
		int small = lastIndexOfXOptimized(arr, elem, si - 1);
		
		return small;
	}
	
	private static int firstIndexOfX(int[] arr, int i, int si) {

		if ( arr.length == 0 ) {
			return -1;
		}
		
		if ( arr[si] == i) {
			return si;
		}
		
		if ( si == arr.length ) {
			return -1;
		}
		
		int small = firstIndexOfX(arr, i, si + 1);
//		if ( arr[si] != i ) {
//			return small;
//		}
		
		return small;
	}

	public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        return towerOfHanoi(n, 1, 2, 3);
    }
	
    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n, int t1, int t3, int t2) {
        //    Write your code here.

        if ( n == 0 ) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        

        ArrayList<ArrayList<Integer>> left = towerOfHanoi( n - 1, t1, t2, t3);
        answer.addAll(left);
        
        ArrayList<Integer> arr = new ArrayList<Integer>(); 
        arr.add(t1);
        arr.add(t3);
        
        answer.add(arr);

        ArrayList<ArrayList<Integer>> right = towerOfHanoi( n - 1, t2, t3, t1 );
        answer.addAll(right);

        return answer;
    }
	
}
