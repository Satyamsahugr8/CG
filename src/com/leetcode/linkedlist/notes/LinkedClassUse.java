package com.leetcode.linkedlist.notes;

import java.util.Scanner;

public class LinkedClassUse {

    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static Node<Integer> increment(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            temp.data++;
            temp = temp.next;
        }
        return head;
    }

    public static Node<Integer> takeInput() {
        Scanner scanner = new Scanner(System.in);
        Integer data = scanner.nextInt();
        Node<Integer> head = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while(tail.next != null) {
                    tail = tail.next;
                }
                //connecting new element into linkedList
                tail.next = currentNode;
            }

            data = scanner.nextInt();
        }

        scanner.close();
        return head;
    }

    public static Integer count(Node<Integer> head) {
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("head = " + temp.data);
            temp = temp.next;
        }
    }

    public static Integer printIth(Node<Integer> head, Integer index) {
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            if (count++ == index) {
                return temp.data;
            }
            temp = temp.next;

        }
        return -1;
    }

    public static void addElementAtIndex(Node<Integer> head, Integer item, Integer index) {
        int count = 0;
        Node<Integer> temp = head;
        Node<Integer> itemToBeAdded = new Node<>(item);

        while (count < index - 1) {
            count++;
            temp = temp.next;
        }

        itemToBeAdded.next = temp.next;
        temp.next = itemToBeAdded;
    }

    public static void main(String[] args) {

        Node<Integer> head = createLinkedList();
//        Node<Integer> head2 = increment(head);
//        print(head2);
//        int countHead = count(head2);
//        System.out.println("countHead = " + countHead);

//        int item = printIth(head , 4);
//        System.out.println("item = " + item);


//        Node<Integer> head = takeInput();
//        print(head);

//        System.out.println("/");

//        addElementAtIndex(head, 50, 8);
//        print(head);



    }
}
