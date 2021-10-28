package DataStructures.TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyTree {
    /**
     * Given a sorted (increasing order) array with unique integer elements to create a binary tree
     * with minimal height
     */
    public static TreeNode createMinimalBST(int[] array){
        return createMinimalBST(array, 0, array.length-1);
    }
    private static TreeNode createMinimalBST(int[] array, int start, int end){
        if(end < start) return null;
        int mid = (start + end) /2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid-1);
        n.right = createMinimalBST(array,mid+1, end);
        return n;
    }

    /**
     * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.
     * implementation1: use any kind of traversal while counting the level along the way.
     * implementation2: use breadth first traversal
     */
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null) {
            current.add(root);
        }
        while(current.size() > 0){
            lists.add(current);
            LinkedList<TreeNode> parent = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode node : parent){
                if(node.left != null){
                    current.add(node.left);
                }
                if(node.right != null){
                    current.add(node.right);
                }
            }
        }
        return lists;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.value = data;
    }
}