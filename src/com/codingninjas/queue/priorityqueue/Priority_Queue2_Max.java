package com.codingninjas.queue.priorityqueue;

import java.util.ArrayList;

public class Priority_Queue2_Max {
    private ArrayList<Integer> heap;

    public Priority_Queue2_Max() {
        this.heap = new ArrayList<>();
    }

    public void insert(Integer element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;

        // upheapify
        while ( childIndex > 0 ) {

            if ( heap.get(childIndex) > heap.get(parentIndex) ) {
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

    public Integer removeMin() throws priorityQueueException {
        
        if ( isEmpty() ) throw new priorityQueueException();
        
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 2 * minIndex + 1;
        int rightChildIndex = 2 * minIndex + 2;

        while ( leftChildIndex < heap.size() ) {
            
            if ( heap.get(leftChildIndex) > heap.get(minIndex) ) {
                minIndex = leftChildIndex;
            }

            if ( rightChildIndex < heap.size() &&  heap.get(rightChildIndex) > heap.get(minIndex) ) {
                minIndex = rightChildIndex;
            }
            if ( minIndex == index ) {
                break;
            }

            //swap
            int temp1 = heap.get(index);
            heap.set(index, heap.get(minIndex));
            heap.set(minIndex, temp1);

            // update index
            index = minIndex;
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
        }

        return temp;
    }


    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
