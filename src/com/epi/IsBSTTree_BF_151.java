package com.epi;


import java.util.LinkedList;
import java.util.Queue;

/*
This is a breadth first iteration of the BST Tree
Here we will maintain a Queue with a List of the Nodes at every Level.
In every iteration we will push the children to the Queue, and then in the next we will first empty the
queue, while simultaneously populating he Queue with the children
 */
public class IsBSTTree_BF_151 {

    public static class BSTreeNode<T>{
        T data;
        BSTreeNode left, right ;

        public BSTreeNode(T data){
            this.data = data;
        }
    }


    //For tracking the Queues
    public static class QueueEntry{

        public BSTreeNode<Integer> treeNode;
        public Integer lowerBound;
        public Integer upperBound;

        public QueueEntry(BSTreeNode<Integer> treeNode,Integer lowerBound, Integer upperBound){
            this.treeNode = treeNode;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

    }
    public static boolean  isBinaryTreeBST(BSTreeNode tree){

        //Add the first entry to the Queue
        Queue<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

        //Now start emptying from the Queue
        QueueEntry headEntry ;
        while ((headEntry =queue.poll()) !=null){
            if (headEntry.treeNode!=null){
               if (headEntry.treeNode.data < headEntry.lowerBound || headEntry.treeNode.data > headEntry.upperBound){
                   return false;
               }


            //Lets add the Elements to the Queue
            queue.add(new QueueEntry(headEntry.treeNode.left, headEntry.lowerBound,headEntry.treeNode.data));
            queue.add(new QueueEntry(headEntry.treeNode.right,headEntry.treeNode.data,headEntry.upperBound));
            }
        }

        return true;
    }


    public static void main(String[] args) {
        BSTreeNode<Integer> tree = new BSTreeNode<Integer>(2);
        BSTreeNode<Integer> nodeLeft = new BSTreeNode<>(1);
        BSTreeNode<Integer> nodeRight = new BSTreeNode<>(3);
        tree.left = nodeLeft;
        tree.right = nodeRight;
        BSTreeNode<Integer> nodeRightRight1 = new BSTreeNode<>(5);
        BSTreeNode<Integer> nodeLeftLeft = new BSTreeNode<>(3);
        nodeRight.left = nodeLeftLeft;
        nodeRight.right = nodeRightRight1;

        System.out.println(isBinaryTreeBST(tree));


    }
}
