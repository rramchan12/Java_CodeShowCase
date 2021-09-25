package com.lc.google;


import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 *see rem leave-tree.jpg
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 */
public class FindLeaves {


    private static class TreeNode{
        int value;
        TreeNode left, right;


        public TreeNode(int value){

            this.value = value;


        }
    }

    public List<List<Integer>> solution;

    public List<List<Integer>> findLeaves(TreeNode node) {

        solution = new ArrayList<>();
        findHeight(node);

        return this.solution;
    }

    private static int findHeight(TreeNode node) {
        if (left == null) {
            return -1;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        int thisNodeHeight = Math.max(leftHeight,rightHeight)+1;
        if (solution.size() != thisNodeHeight) {
            solution = new ArrayList<>();
        }

        solution.get(thisNodeHeight).add(node.value);

        return thisNodeHeight;
    }


        public static void main(String[] args) {

            FindLeaves findLeaves = new FindLeaves();
            TreeNode tree = new TreeNode(2);
            TreeNode nodeLeft = new TreeNode(1);
            TreeNode nodeRight = new TreeNode(3);
            tree.left = nodeLeft;
            tree.right = nodeRight;
            TreeNode nodeRightRight1 = new TreeNode(5);

            nodeRight.right = nodeRightRight1;

            System.out.println(findLeaves.findLeaves(tree));



    }
}



