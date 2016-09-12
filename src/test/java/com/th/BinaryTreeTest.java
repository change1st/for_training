package com.th;

import com.th.BinaryTree;
import org.junit.Test;

/**
 * Created by mr_change on 16-8-9.
 */
public class BinaryTreeTest {

    private BinaryTree binaryTree = new BinaryTree();

    @Test
    public void testTree() {
        BinaryTree.TreeNode treeNode = binaryTree.createTree(binaryTree.nodes);
        binaryTree.printTree(treeNode);
        System.out.println("");
        binaryTree.printTreeWithLevel(treeNode);
    }

}