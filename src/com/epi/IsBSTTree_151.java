package com.epi;

public class IsBSTTree_151 {

    private static class BSTNode<T>{
        public T data;
        public BSTNode<T> left, right;

        public BSTNode(T o1){
            this.data = o1;
        }
    }



    public static boolean isBinaryTree(BSTNode<Integer> tree){
        return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * This is a depth first traversal with O(n) Complexity
     * @param tree
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static boolean areKeysInRange(BSTNode<Integer> tree, Integer lowerBound, Integer upperBound){

        if (tree==null)
            return true;
        else if (Integer.compare(tree.data,lowerBound) <0 || Integer.compare(tree.data,upperBound) >0)
            return false;



        return areKeysInRange(tree.left,lowerBound,tree.data) && areKeysInRange(tree.right,tree.data, upperBound);
    }

    public static void main(String[] args) {
        BSTNode<Integer> tree = new BSTNode<Integer>(2);
        BSTNode<Integer> nodeLeft = new BSTNode<>(1);
        BSTNode<Integer> nodeRight = new BSTNode<>(3);
        tree.left = nodeLeft;
        tree.right = nodeRight;
        BSTNode<Integer> nodeRightRight1 = new BSTNode<>(5);
        BSTNode<Integer> nodeLeftLeft = new BSTNode<>(3);
        nodeRight.left = nodeLeftLeft;
        nodeRight.right = nodeRightRight1;

        System.out.println(isBinaryTree(tree));


    }
}
