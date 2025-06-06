package com.codingninjas.queue.priorityqueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class MaxPQComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if ( o1 < o2 ) return -1;
        else if ( o1 > o2 ) return 1;
        return 0;
    }
    
}

class MinPQComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if ( o1 > o2 ) return -1;
        else if ( o1 < o2 ) return 1;
        return 0;
    }
    
}
@SuppressWarnings("unused")
public class PriorityQueueUse {

    public static void main(String[] args) throws PriorityQueueException {

        // priority_Queue2MinUse();
        // priority_Queue2MaxUse();
        // inbuiltPriorityQueueUse();
        // sortKSorted();
        // kLargestElement();
//         inbuiltMaxPriorityQueueUse();
//    	int[] arr = {42, 20, 18, 6, 14, 11, 9, 4};
//    	int[] arr = {2,11,10,1,3};
//    	boolean s = checkMax(arr);
//    	System.out.println(s);
//    	int[] nums = {3,2,1,5,6,4};
//    	int ss = findKthLargest(nums, 2);
//    	System.out.println(ss);
    	
    	int[] aar = {999999999,999999999,999999999};
//    	int a = buyTicket(aar, aar.length, 3);
//    	System.out.println(a);
    	
//    	minPriorityQueue(arr);

    	int n = minOperations(aar, 1000000000);
    	System.out.println(n);
    }
    
    
    private static int buyTicket(int[] aar, int n, int k) throws PriorityQueueException {
		
    	Queue<Integer> queue = new LinkedList<Integer>();
    	MinPQComparator min = new MinPQComparator();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(min);

        for (int i = 0; i < aar.length; i++) {
            pQueue.add(aar[i]);
            queue.add(i);
        }
    	
    	System.out.println(pQueue);
    	System.out.println(queue);
    	
    	int count = 0;
    	int tempk = 0;
    	
    	while ( !queue.isEmpty() ) {
			
    		if ( queue.peek() == pQueue.peek() ) {
				count++;
				pQueue.remove();
				queue.remove();
			}
    		
    		else if ( queue.peek() < pQueue.peek() ) {
    			int element = queue.remove();
    			queue.add(element);
    			tempk++;
    			if ( tempk == k ) {
    				tempk = queue.size() - 1;
    			}
    		}
    		
    		
		}
    	
    	return count;
    	
		
	}


	public static int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        int i = 0;
        
        while ( i < k ) {
            pQueue.add(nums[i]);
            i++;
        }
        
        System.out.println(pQueue);

        while ( i < nums.length ) {
            if ( nums[i] > pQueue.peek() ) {
                pQueue.remove();
                pQueue.add(nums[i]);
                i++;
            } else {
                i++;    
            }
            
        }

        return pQueue.remove();

    }


	private static boolean checkMax(int[] arr) {
		
		int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int heapSize = arr.length;

        while (leftChildIndex < heapSize) {

            int maxIndex = index;

            if (arr[leftChildIndex] > arr[maxIndex]) {
                return false;
            }
            if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]) {
                return false;
            }
            
            index = leftChildIndex;
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
              
        }
        
        while (leftChildIndex < heapSize) {

            int maxIndex = index;

            if (arr[leftChildIndex] > arr[maxIndex]) {
                return false;
            }
            if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]) {
                return false;
            }
            
            index = rightChildIndex;
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;

        }

        return true;
        
    }

    private static void insertIntoVirtualHeapMax(int[] arr, int i) {

        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {

            if (arr[childIndex] < arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    private static void insertIntoVirtualHeapMin(int[] arr, int i) {

        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {

            if (arr[childIndex] > arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;

                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }

        }

    }

    private static int removeFromVirtualHeapMax(int[] arr, int heapSize) {

        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        while (leftChildIndex < heapSize) {

            int minIndex = index;

            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }
            if (minIndex != index) {
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;

                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;

            } else {
                break;
            }

        }
        return temp;
    }

    private static int removeFromVirtualHeapMin(int[] arr, int heapSize) {

        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        while (leftChildIndex < heapSize) {

            int maxIndex = index;

            if (arr[leftChildIndex] > arr[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex != index) {
                int temp1 = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp1;

                index = maxIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;

            } else {
                break;
            }
        }

        return temp;
    }

    private static void minPriorityQueue(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
        	insertIntoVirtualHeapMin(arr, i);
            // insertIntoVirtualHeapMax(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromVirtualHeapMin(arr, arr.length - i);
            // arr[arr.length - 1 - i] = removeFromVirtualHeapMax(arr, arr.length - i);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static void maxPriorityQueue() {
        int arr[] = { 5, 1, 9, 2, 0, 6 };

        for (int i = 0; i < arr.length; i++) {
            insertIntoVirtualHeapMax(arr, i);
            // insertIntoVirtualHeapMax(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromVirtualHeapMax(arr, arr.length - i);
            // arr[arr.length - 1 - i] = removeFromVirtualHeapMax(arr, arr.length - i);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    static void priority_Queue2MinUse() throws PriorityQueueException {
        Priority_Queue2_Min pq = new Priority_Queue2_Min();
        int arr[] = { 5, 1, 9, 2, 0, 6 };

        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.removeMin() + " ");
        }

        System.out.println();
    }

    static void priority_Queue2MaxUse() throws PriorityQueueException {
        
    	Priority_Queue2_Max pq = new Priority_Queue2_Max();
        int arr[] = { 5, 1, 9, 2, 0, 6 };

        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.removeMin() + " ");
        }

        System.out.println();
    }

    private static void kLargestElement() {
        
        int arr[] = {2,15,8,9,12,13,20};
        int ans[] = kLargestElement(arr, 3);
        
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] kLargestElement(int[] arr, int k) {
        
        MaxPQComparator max = new MaxPQComparator();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(max);
        
        int i = 0;
        
        while ( i < k ) {
            pQueue.add(arr[i]);
            i++;
        }

        while ( i < arr.length ) {
            if ( arr[i] > pQueue.peek() ) {
                pQueue.remove();
                pQueue.add(arr[i]);
                i++;
            } else {
                i++;
            }
        }

        int j = 0;
        int []anew = new int[pQueue.size()];
        while (!pQueue.isEmpty()) {
            anew[j] = pQueue.remove();
            j++;
        }
        
        return anew;
    }

    private static void sortKSorted() {

        int[] arr = {2,1,4,8,6,9};
        sortKSorted(arr,3);

        for (int i : arr) {
            System.out.print(i +" ");
        }
        System.out.println();

    }

    private static void sortKSorted(int[] arr, int k) {
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        int i = 0;
        
        while ( i < k ) {
            pQueue.add(arr[i]);
            i++;
        }

        while ( i < arr.length ) {
            arr[i - k] = pQueue.remove();
            pQueue.add(arr[i]);
            i++;
        }

        for (int j = arr.length - k; j < arr.length; j++) {
            arr[j] = pQueue.remove();
        }
        
    }

    private static void inbuiltPriorityQueueUse() {
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int arr[] = { 9, 1, 0, 4, 7, 3 };

        for (int i = 0; i < arr.length; i++) {
            pQueue.add(arr[i]);
        }

        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.remove() + " ");
        }
        System.out.println();
    
    }

    private static void inbuiltMaxPriorityQueueUse() {
        
        MaxPQComparator max = new MaxPQComparator();
        MinPQComparator min = new MinPQComparator();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(max);
        // PriorityQueue<Integer> pQueue = new PriorityQueue<>(min);
        
        int arr[] = { 9, 1, 0, 4, 7, 3 };

        for (int i = 0; i < arr.length; i++) {
            pQueue.add(arr[i]);
        }
        
        System.out.println(pQueue);

        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.remove() + " ");
        }
        System.out.println();
    
    }
    
    public static int minOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pQueue.add(nums[i]);
        }

        // int a = -1;
        // while ( !pQueue.isEmpty() && pQueue.peek() < k ) {
        //     int curr = pQueue.remove();
        //     if ( a == -1 ) {
        //         a = curr;
        //     }
        //     else {
        //         ++count;
        //         int c = a*2 + curr;
        //         pQueue.add(c);
        //         a = -1;
        //     }
        // }

        
        while ( !pQueue.isEmpty() && pQueue.peek() < k ) {
            int a = pQueue.remove();
            System.out.println("a "+ a);
            if ( !pQueue.isEmpty() ) {
                int b = pQueue.remove();
                System.out.println("b "+ b);
                int c = a * 2 + b;
                if ( c > 0 ) {
                	pQueue.add(c);
                } else {
                	pQueue.add(k);
                }
                count++;
            } else {
                break;
            }
        }

        return count; 
    }

}
