package com.shivam.practice;

public class MiddleOfLL {

    private Node head;
    int size;
    public MiddleOfLL() {
        this.size = 0;
    }

    // structure of Node
    public static class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
        }
    }

    // insertion
    public void insertAtFirst(int val) {

        Node node = new Node(val);

        if (head == null) {
            head = node;
            size ++;
            return;
        }

        node.next = head;
        head = node;
        size++;
    }


    // middle of List
    public int findMiddle() {

        if (head == null) {
            System.out.println("List not Exist");
            return -1;
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // goes one step ahead
            fast = fast.next.next; // goes two steps ahead
        }

        return slow.value;  //where slow will be at the time fast reached to null will be middle node
    }


    // display
    public void display() {
        if (head == null) {
            System.out.println("List Doesn't Exist");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
        System.out.println("Size of List: " + size);
    }

    // main - fn
    public static void main(String[] args) {
        MiddleOfLL list = new MiddleOfLL();
        list.insertAtFirst(17);
        list.insertAtFirst(19);
        list.insertAtFirst(18);
        list.insertAtFirst(333);
        list.insertAtFirst(10);
        list.insertAtFirst(39);

        list.display();

        int mid = list.findMiddle();
        System.out.println(mid);
    }
}
