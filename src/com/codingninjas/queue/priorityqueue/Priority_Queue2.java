package com.codingninjas.queue.priorityqueue;

import java.util.ArrayList;

public class Priority_Queue2 {
    private ArrayList<Integer> heap;

    public Priority_Queue2() {
        this.heap = new ArrayList<>();
    }

    public void insert(Integer element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;

        // upheapify
        while ( childIndex > 0 ) {

            if ( heap.get(childIndex) < heap.get(parentIndex) ) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
            } else {
                return;
            }

        }

    }

    public Integer getMin() throws priorityQueueException {
        if ( isEmpty() ) throw new priorityQueueException();
        return heap.get(0);
    }


    public Integer removeMin() {
        return 0;
    }


    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        System.out.println("ss");
    }
}
