package com.th.Algorithm;

public class PrintTree {

    private static void printLinked(LinkedNode linkedNode) {
        LinkedNode node = linkedNode;
        while (node != null) {
            System.out.print(node.value.value);
            System.out.print(" ");
            node = node.prev;
        }

        node = linkedNode;
        while (node != null) {
            System.out.print(node.value.value);
            System.out.print(" ");
            node = node.next;
        }
    }

    /**
     * 二叉树转双向链表
     * @param node
     * @return
     */
    private static LinkedNode treeToLinked(Node node) {
        if (node == null) {
            return null;
        }

        LinkedNode linkedNode = new LinkedNode(node);
        LinkedNode left = treeToLinked(node.left);
        while (left != null) {
            if (left.next == null) {
                linkedNode.prev = left;
                left.next = linkedNode;
                break;
            }
            left = left.next;
        }
        LinkedNode right = treeToLinked(node.right);
        while (right != null) {
            if (right.prev == null) {
                linkedNode.next = right;
                right.prev = linkedNode;
                break;
            }
            right = right.prev;
        }

        return linkedNode;
    }

    private static int depth(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 二叉树左叶子节点的和
     * @param node
     * @return
     */
    private static int leftLeafSum(Node node) {
        if (node == null) {
            return 0;
        }
        int value = 0;
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                value = node.left.value;
            }
        }

        int leftSum = leftLeafSum(node.left);
        int rightSum = leftLeafSum(node.right);
        return leftSum + rightSum + value;
    }

    /**
     * Z字形打印二叉树
     * @param node
     */
    private static void printZFloor(Node node) {
        Stack stack1 = new Stack();
        stack1.push(node);
        Stack stack2 = new Stack();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    Node current = stack1.pop();
                    System.out.print(current.value);
                    System.out.print(" ");
                    if (current.left != null) {
                        stack2.push(current.left);
                    }
                    if (current.right != null) {
                        stack2.push(current.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    Node current = stack2.pop();
                    System.out.print(current.value);
                    System.out.print(" ");
                    if (current.right != null) {
                        stack1.push(current.right);
                    }
                    if (current.left != null) {
                        stack1.push(current.left);
                    }
                }
            }
        }
    }

    /**
     * 层序遍历二叉树
     * @param node
     */
    private static void printFloor(Node node) {
        Queue queue = new Queue();
        queue.add(node);
        while (!queue.isEmpty()) {
            LinkedNode linkedNode = queue.poll();
            Node current = linkedNode.value;
            System.out.print(current.value);
            System.out.print(" ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private static class Stack {
        private LinkedNode head;

        private void push(Node node) {
            if (node == null) {
                return;
            }

            LinkedNode linkedNode = new LinkedNode(node);
            if (head == null) {
                head = linkedNode;
            } else {
                linkedNode.next = head;
                head = linkedNode;
            }
        }

        private Node pop() {
            Node node = null;
            if (head != null) {
                node = head.value;
                head = head.next;
            }

            return node;
        }

        private boolean isEmpty() {
            return head == null;
        }
    }

    private static class Queue {
        private LinkedNode head;
        private LinkedNode tail;

        private void add(Node node) {
            if (node == null) {
                return;
            }

            LinkedNode linkedNode = new LinkedNode(node);
            if (head == null) {
                head = linkedNode;
                tail = linkedNode;
            } else {
                tail.next = linkedNode;
                tail = linkedNode;
            }
        }

        private LinkedNode poll() {
            LinkedNode linkedNode = head;
            if (head != null) {
                head = head.next;
            }

            return linkedNode;
        }

        private boolean isEmpty() {
            return head == null;
        }
    }

    static class LinkedNode {
        private Node value;
        private LinkedNode next;
        private LinkedNode prev;

        public LinkedNode(Node value) {
            this.value = value;
        }

        public Node getValue() {
            return value;
        }

        public void setValue(Node value) {
            this.value = value;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }

        public LinkedNode getPrev() {
            return prev;
        }

        public void setPrev(LinkedNode prev) {
            this.prev = prev;
        }
    }

    /**
     * 中序遍历二叉树
     * @param node
     */
    private static void printNode(Node node) {
        if (node == null) {
            return;
        }

        printNode(node.left);
        System.out.print(node.value);
        System.out.print(" ");
        printNode(node.right);
    }

    private static Node createTree(int[] arr) {
        return createNode(arr, 0, null);
    }

    private static Node createNode(int[] arr, int index, Node parent) {
        if (index >= arr.length) {
            return null;
        }


        Node node = new Node(arr[index]);
        Node left = createNode(arr, 2 * index + 1, node);
        Node right = createNode(arr, 2 * index + 2, node);

        node.parent = parent;
        node.left = left;
        node.right = right;

        return node;
    }

    private static class Node {
        private int value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        Node root = createTree(arr);
        printNode(root);
        System.out.println();
        printFloor(root);
        System.out.println();
        printZFloor(root);
        System.out.println();
        int leftLeafSum = leftLeafSum(root);
        System.out.println(leftLeafSum);
        int depth = depth(root);
        System.out.println(depth);
        LinkedNode linkedNode = treeToLinked(root);
        printLinked(linkedNode);
    }
}
