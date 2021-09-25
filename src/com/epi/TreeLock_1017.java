package com.epi;


/**
 * This is giving is_locked = o(1)
 * unlock and lock - O(h+m)
 */
public class TreeLock_1017 {

    private class BinaryTreeNode{
        boolean locked;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        BinaryTreeNode parent;
    }

    public boolean checkLockPrecondition(BinaryTreeNode node){

        //check children
        boolean left = checkChildLockPrecondition(node.leftChild);
        if (!left)
            return false;
        boolean right = checkChildLockPrecondition(node.rightChild);
        if (!right)
            return false;

        //check ancestors
        BinaryTreeNode parentNode = node.parent;
        while (parentNode!=null){
            if (parentNode.locked)
                return false;
            parentNode = parentNode.parent;
        }


        return true;
    }

    private boolean checkChildLockPrecondition(BinaryTreeNode node) {
        if (node==null)
            return true;

        if (node.locked)
            return false;

        //check children
        boolean left = checkChildLockPrecondition(node.leftChild);
        if (!left)
            return false;
        boolean right = checkChildLockPrecondition(node.rightChild);
        return right;


    }


    /**
     * The main set of methods
     * @param node
     * @return
     */
    public boolean unlock(BinaryTreeNode node){
        if(!checkChildLockPrecondition(node))
            return false;

        node.locked=false;
        return true;

    }

    public boolean lock(BinaryTreeNode node){
        if(!checkChildLockPrecondition(node))
            return false;

        node.locked=true;
        return true;

    }

    public boolean is_locked(BinaryTreeNode node){
        return node.locked;
    }

}

//We need to implement with O(h) requirement then look at the alternative one
