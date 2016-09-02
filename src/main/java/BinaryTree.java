import com.google.common.collect.Lists;
import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mr_change on 16-8-8.
 */
public class BinaryTree {

    int[] nodes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

    class TreeNode {
        public int node;
        public TreeNode leftChildTreeNode;
        public TreeNode rightChildTreeNode;
    }

    public TreeNode createTree(int[] nodes) {
        TreeNode root = null;
        List<TreeNode> treeNodes = Lists.newArrayList();
        for (int node : nodes) {
            TreeNode treeNode = new TreeNode();
            treeNode.node = node;
            treeNodes.add(treeNode);
        }

        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (root == null) {
                root = treeNode;
            }

            if (2 * (i + 1) - 1 < treeNodes.size()) {
                treeNode.leftChildTreeNode = treeNodes.get(2 * (i + 1) - 1);
            }

            if (2 * (i + 1) < treeNodes.size()) {
                treeNode.rightChildTreeNode = treeNodes.get(2 * (i + 1));
            }
        }

        return root;
    }

    public void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.printf(treeNode.node + " ");
        printTree(treeNode.leftChildTreeNode);
        printTree(treeNode.rightChildTreeNode);
    }

    public void printTreeWithLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int pSize = queue.size();
            while (pSize > 0) {
                if (pSize <= 0) {
                    break;
                }

                TreeNode treeNode = queue.poll();
                if (treeNode.leftChildTreeNode != null) {
                    queue.add(treeNode.leftChildTreeNode);
                }

                if (treeNode.rightChildTreeNode != null) {
                    queue.add(treeNode.rightChildTreeNode);
                }

                System.out.printf(treeNode.node + " ");
                pSize--;
            }
        }
    }

    public static <T> T[] toArray(T[] a) {
        int size = 10;
        Integer[] elements = {};
        if(a.length < size) {
            @SuppressWarnings("unchecked")
            T[] b = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return b;
        }

        if(a.length > size) {
            a[size] = null;
        }

        return a;
    }

    public static void main(String[] args) {
        String[] b = {"a", "b"};
        toArray(b);

        String str = "eqweqwerqwerb";
        if(str.endsWith("b")) {
            System.out.println("yes");
        }
    }
}