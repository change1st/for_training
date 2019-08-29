package com.th.Algorithm;

public class Linked {

    private static Node deleteRepeat(Node head) {
        Node temp = head.next;
        Node repeat = head;
        Node prev = head;
        Node newHead = head;

        int count = 0;
        while (temp != null) {
            if (repeat.value == temp.value) {
                repeat.next = temp.next;
                count++;
            } else {
                if (count > 0) {
                    if (prev == repeat) {
                        prev = temp;
                        newHead = prev;
                    } else {
                        prev.next = temp.next;
                    }
                    count = 0;
                } else {
                    prev = repeat;
                }

                repeat = temp;
            }
            temp = temp.next;
        }

        if (count > 0) {
            if (prev == repeat) {
                newHead = null;
            } else {
                prev.next = null;
            }
        }

        return newHead;
    }

    private static Node createLinked(int[] arr) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        return head;
    }

    static class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4};
        Node head = createLinked(arr);
        Node newHead = deleteRepeat(head);
        while (newHead != null) {
            System.out.print(newHead.value);
            System.out.print(" ");
            newHead = newHead.next;
        }
    }
}
