package com.epi;

public class TreeLock_1017_1 {

    private class BinaryTreeNode{

        boolean locked = false;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        BinaryTreeNode parent;
        int lockedDescendantCount =0;
    }

    /*
    The method maintains a set of locked descendants. This will eliminate the
    O(m) traversal and only O(h) will remain
     */

    public boolean is_locked(BinaryTreeNode node){
        return node.locked;

    }

    public boolean lock(BinaryTreeNode node){

        if (node==null)
            return false;

        if(!canLockUnlock(node))
            return false;

        node.locked = true;

        BinaryTreeNode parentNode = node.parent;
        while (parentNode != null){
            parentNode.lockedDescendantCount +=1;
            parentNode = parentNode.parent;
        }
        return true;
    }

    public boolean unlock(BinaryTreeNode node){
        if (node == null){
            return false;
        }

        if (!canLockUnlock(node)){
            return false;
        }

        node.locked= false;
        BinaryTreeNode parentNode = node.parent;
        while(parentNode != null){
            parentNode.lockedDescendantCount -=1 ;
            parentNode = parentNode.parent;
        }
        return true;
    }

    public boolean canLockUnlock(BinaryTreeNode node){
        if (node.lockedDescendantCount>0){
            return false;
        }


        //Check for all the parents
        BinaryTreeNode parentNode = node.parent;
        while (parentNode !=null){
            if (parentNode.locked)
                return false;
            parentNode = parentNode.parent;
        }
        return true;
    }
}
