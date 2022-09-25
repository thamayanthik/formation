package com.formation.algomarthon.tree;

class LockingBinaryTreeNode {
    public int val;
    public LockingBinaryTreeNode left;
    public LockingBinaryTreeNode right;
    public LockingBinaryTreeNode parent;
    public boolean locked = false;
    public int lockedDescendantsCount;

    public boolean isLocked(LockingBinaryTreeNode node) {
        return node.locked;
    }

    public boolean lock(LockingBinaryTreeNode node) {
        if (canLockOrUnlock(node)) {
            node.locked = true;

            LockingBinaryTreeNode currentNode = node.parent;
            while (currentNode != null) {
                currentNode.lockedDescendantsCount += 1;
                currentNode = currentNode.parent;
            }
        } else {
            return false;
        }

        return true;
    }

    public boolean unlock(LockingBinaryTreeNode node) {
        if (canLockOrUnlock(node)) {
            node.locked = true;

            LockingBinaryTreeNode currentNode = node.parent;
            while (currentNode != null) {
                currentNode.lockedDescendantsCount -= 1;
                currentNode = currentNode.parent;
            }
        } else {
            return false;
        }

        return true;
    }

    public boolean canLockOrUnlock(LockingBinaryTreeNode node) {
        if (node.lockedDescendantsCount > 0) {
            return false;
        }

        LockingBinaryTreeNode currentNode = node.parent;
        while (currentNode != null) {
            if (currentNode.locked) {
                return false;
            }
            currentNode = currentNode.parent;
        }

        return true;
    }
}

public class LockableBinaryTree {
    public static void main(String[] args) {
        LockingBinaryTreeNode l = new LockingBinaryTreeNode();
        l.val = 10;

        LockingBinaryTreeNode l1 = new LockingBinaryTreeNode();
        l1.val = 5;
        l.left  = l1;
        l1.parent = l;

        LockingBinaryTreeNode l2 = new LockingBinaryTreeNode();
        l2.val = 15;
        l.right  = l2;
        l2.parent = l;

        System.out.println(l.isLocked(l));
        System.out.println(l.lock(l));
        System.out.println(l.unlock(l));
    }


}
