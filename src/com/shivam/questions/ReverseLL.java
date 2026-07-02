package com.shivam.questions;

public class ReverseLL {
    private Node head;
    private Node tail;

    public static class Node {
        Node next;
        int val;

        public Node(int value) {
            this.val = value;
        }
    }

    public void insertAtLast(int val) {
        if (head == null) {
            Node node = new Node(val);
            head = node;
            tail = node;

            // is important beCoz if there is no - node then without return will run if-block also below code => 1st node insert 2 times
            return;
        }

        Node Newnode = new Node(val);
        tail.next = Newnode;
        tail = Newnode;
    }


    // reversal of list using recursion
    public Node recursiveReverse(Node pre, Node curr) {
        if (curr == null) { //  base - case
            head = pre; // makes previous as newHead and return
            return head;
        }

        //🌟🤯
        Node next = curr.next; // first saving the next of curr so that for further recursive call "curr" next can be pass to move forward before overwriting the curr -> next
        curr.next = pre;  // for link reversal, Overwriting current - next
        return recursiveReverse(curr, next); // move forward
    }


    // reversal of List using iteration(In - place)
    public void reverse() {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if (next != null) { // becOZ next is pointing to current -> next so it can be null becOz we are traversing till current is not null
                next = next.next; // 🌟🌟 saved next of curr , before the link break.
            }
        }
        head = prev; // prev - becomes new head
    }




    public void display() {
        if (head == null) {
            System.out.println("List is Empty...");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();
        list.insertAtLast(7);
        list.insertAtLast(4);
        list.insertAtLast(3);
        list.insertAtLast(8);

        list.display();

//        // reversal recursion
//        list.recursiveReverse(null, list.head);
//        list.display();

        // iteration (In - place reversal)
        list.reverse();
        list.display();

    }
}
