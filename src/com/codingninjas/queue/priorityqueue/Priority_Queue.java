package com.codingninjas.queue.priorityqueue;

import java.util.ArrayList;

class Element<T> {
    T value;
    int periority;
    
    public Element() {
    	
    }
    
	public Element(T value, int periority) {
		super();
		this.value = value;
		this.periority = periority;
	}
       
}

public class Priority_Queue<T> {
    
    private ArrayList<Element<T>> heap;

    public Priority_Queue() {
        this.heap = new ArrayList<>();
    }

    public void insert(T value, int periority) {

    	Element<T> element = new Element<>();
    	element.value = value;
    	element.periority = periority;
    	heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex).periority > heap.get(parentIndex).periority ) {
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}

    }

    public Element<T> getMin() throws PriorityQueueException {
        if ( isEmpty() ) throw new PriorityQueueException();
        return heap.get(0);
    }


    public Element<T> removeMin() throws PriorityQueueException {
    	
    	if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
        
        Element<T> minEle = getMin();
        
        //Set the last priority element as the new root
        heap.set(0,heap.get(heap.size()-1));
        
        //Remove the last priority element
        heap.remove(heap.size()-1);
        
        //Traverse from root to leaf, and swap values if needed to maintain min. heap order property
        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex=2*parentIndex+2;
        
        while(leftChildIndex < heap.size()) {
            int minIndex = parentIndex;
            
            if(heap.get(minIndex).periority < heap.get(leftChildIndex).periority) {
                minIndex = leftChildIndex;
            }
            
            if(rightChildIndex < heap.size()) {
                if(heap.get(minIndex).periority < heap.get(rightChildIndex).periority ) {
                	minIndex = rightChildIndex;
            	}
            }
            
            if(minIndex == parentIndex) {
                return minEle;
            }
            
            Element<T> temp = heap.get(parentIndex);
            heap.set(parentIndex,heap.get(minIndex));
            heap.set(minIndex,temp);
            
            parentIndex=minIndex;
            leftChildIndex=2*parentIndex+1;
            rightChildIndex=2*parentIndex+2;
        }
        return minEle;
    }


    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
    
}
