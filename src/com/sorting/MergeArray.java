package com.sorting;

public class MergeArray {

	public static int[] mergeArray(int[] arr, int[] brr) {
		int a[] = new int[arr.length + brr.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i<arr.length && j<brr.length) {
			if(arr[i] < brr[j]) {
				a[k] = arr[i];
				i++;
				k++;
			}
			else if(brr[j] < arr[i]) {
				a[k] = brr[j];
				j++;
				k++;
			}
		}

		while(i<arr.length) {
			a[k] = arr[i];
			i++;
			k++;
		}

		while(j<brr.length) {
			a[k] = brr[j];
			j++;
			k++;
		}
		return a;
	}

	public static void main(String[] args) {
		int arr[] = {0,0};
		int brr[] = {0,0};

		int[] a = mergeArray(arr, brr);

		for (int r : a) {
			System.out.print(r + " ");
		}
		
//		Double d = findMedianOfNewArray(a);
//		System.out.println("d = " + d);
	}

//	public static Double findMedianOfNewArray(int[] x) {
//
//        if (x.length%2 == 0) {
//			if (x[(x.length/2)-1]+ x[(x.length/2)] == 0) {
//				return (double) 0;
//			}
//            return (x[(x.length/2)-1]+ x[(x.length/2)])/2.0;
//
//        }
//		return (double) x[x.length/2];
//	}

}