package com.codingninjas.queue.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueUse {

    private static void insertIntoVirtualHeap(int[] arr, int i) {

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

    private static void insertIntoVirtualHeapMax(int[] arr, int i) {

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

    private static int removeFromVirtualHeap(int[] arr, int heapSize) {

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

    private static int removeFromVirtualHeapMax(int[] arr, int heapSize) {

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

    void minPriorityQueue() {
        int arr[] = { 5, 1, 9, 2, 0, 6 };

        for (int i = 0; i < arr.length; i++) {
            insertIntoVirtualHeap(arr, i);
            // insertIntoVirtualHeapMax(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromVirtualHeap(arr, arr.length - i);
            // arr[arr.length - 1 - i] = removeFromVirtualHeapMax(arr, arr.length - i);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    void maxPriorityQueue() {
        int arr[] = { 5, 1, 9, 2, 0, 6 };

        for (int i = 0; i < arr.length; i++) {
            insertIntoVirtualHeap(arr, i);
            // insertIntoVirtualHeapMax(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = removeFromVirtualHeap(arr, arr.length - i);
            // arr[arr.length - 1 - i] = removeFromVirtualHeapMax(arr, arr.length - i);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    static void priority_Queue2MinUse() throws priorityQueueException {
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

    static void priority_Queue2MaxUse() throws priorityQueueException {
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

    public static void main(String[] args) throws priorityQueueException {

        // priority_Queue2MinUse();
        // priority_Queue2MaxUse();
        // inbuiltPriorityQueueUse();
        sortKSorted();
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

}
