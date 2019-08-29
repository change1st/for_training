package com.th.Algorithm;

import java.util.List;

public class NodeTraining {

    public static Node reverseSegment(Node head, int k) {
        if (k < 1) {
            return head;
        }
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        if (length < k) {
            return head;
        }

        int notReverseCount = length % k;
        boolean reverse = !(notReverseCount > 0);
        Node tail = head;
        Node newHead = notReverseCount > 0 ? head : null;
        int count = 0;
        temp = head;
        while (temp != null) {
            if (reverse) {
                Node segmentTail = temp;
                Node segmentTemp = null;
                Node segmentHead = temp;
                for (; count < k;count++) {
                    segmentTemp = temp;
                    temp = temp.getNext();
                    segmentTemp.setNext(segmentHead);
                    segmentHead = segmentTemp;
                    tail.setNext(segmentHead);
                }
                segmentTail.setNext(temp);

                tail = segmentTail;
                temp = tail;

                count = 0;
                if (newHead == null) {
                    newHead = segmentHead;
                }
            } else {
                count++;
                if (count >= notReverseCount) {
                    count = 0;
                    reverse = true;
                    tail = temp;
                }
            }
            temp = temp.getNext();
        }

        return newHead;
    }

    public static Node createLinked(int[] arr) {
        Node head = null, tail = null;
        for (int value : arr) {
            Node node = new Node();
            node.setValue(value);
            if (head == null) {
                head = tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
        }

        return head;
    }

    public static void printLinked(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 0;
        Node head = createLinked(arr);
        Node newHead = reverseSegment(head, k);
        printLinked(newHead);
    }

    static class Node {
        private int value;
        private Node next;

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
}
