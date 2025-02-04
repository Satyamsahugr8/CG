package com.codingninjas.queue.priorityqueue;

import java.util.ArrayList;

class Element<T> {
    T value;
    int periority;
}

public class Priority_Queue<T> {
    
    private ArrayList<Element<T>> heap;

    public Priority_Queue() {
        this.heap = new ArrayList<>();
    }

    public void insert(T value, int periority) {

        // heap.add();

    }

    public T getMin() throws priorityQueueException {
        if ( isEmpty() ) throw new priorityQueueException();
        return heap.get(0).value;
    }


    public T removeMin() {
        return null;
    }


    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    
}
