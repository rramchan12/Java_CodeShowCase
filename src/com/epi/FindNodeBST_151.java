package com.epi;

public class FindNodeBST_151 {

    private static class BSTNode<T>{
        public T data;
        public BSTNode<T> left, right;

        public BSTNode(T o1){
            this.data = o1;
        }
    }

    private static boolean searchTree(Integer data, BSTNode<Integer> tree){
        if (tree == null)
            return false;
        if (tree.data ==data)
            return true;

       return (data <tree.data) ? searchTree(data, tree.left) : searchTree(data, tree.right);

        }


    public static void main(String[] args) {
        BSTNode<Integer> tree = new BSTNode<Integer>(2);
        BSTNode<Integer> nodeLeft = new BSTNode<>(1);
        BSTNode<Integer> nodeRight = new BSTNode<>(3);

        tree.left = nodeLeft;
        tree.right = nodeRight;

        System.out.println(searchTree(1,tree));

    }
}
