package DataStructures.TreeAndGraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyTreeTest {

    @Test
    void createMinimalBST() {
        int[] array = {1,2,3,4,5};
        TreeNode root = MyTree.createMinimalBST(array);
        assertEquals(3, root.value);
        assertEquals(1, root.left.value);
        assertEquals(2, root.left.right.value);
        assertEquals(4, root.right.value);
        assertEquals(5, root.right.right.value);
    }

    @Test
    void createLevelLinkedList() {
        int[] array = {1,2,3,4,5};
        TreeNode root = MyTree.createMinimalBST(array);
        ArrayList<LinkedList<TreeNode>> lists = MyTree.createLevelLinkedList(root);
        assertEquals(3,lists.size());
        assertEquals(3, lists.get(0).get(0).value);
        assertEquals(2, lists.get(1).size());
        assertEquals(2, lists.get(2).size());
    }
}