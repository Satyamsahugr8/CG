package com.smarsh;
import java.util.*;

public class MoveKElementsUsingStack {
    public static void moveKElementsToBack(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid k or queue");
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue first k elements and push them onto stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Pop all elements and enqueue back - this reverses order, so we use another structure
        // Instead, push first k elements into stack, then pop from stack into a temporary queue
        Queue<Integer> tempQueue = new LinkedList<>();

        while (!stack.isEmpty()) {
            tempQueue.offer(stack.pop());
        }

        // Step 3: Now enqueue elements from tempQueue back to main queue, which preserves original order
        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.poll());
        }

        // Step 4: Move the remaining elements to the back of the queue to maintain order
        int sizeAfter = queue.size();
        for (int i = 0; i < sizeAfter - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 2;

        System.out.println("Original Queue: " + queue);
        moveKElementsToBack(queue, k);
        System.out.println(k + " elements to back: " + queue);
    }
}
