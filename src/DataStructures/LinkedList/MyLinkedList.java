package DataStructures.LinkedList;

import java.util.HashSet;

public class MyLinkedList {
    /**
     * remove duplicate
     * how would you solve this temporary buffer is not allowed
     */
    public static void removeDup(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node prev = new Node(0);
        while(head != null){
            if(set.contains(head.data)){
                prev.next = head.next;
            }else{
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

    /**
     * remove the kth node to the last
     */
    public static Node lastKthNode(Node head, int k){
        Node dummy = new Node(0, head);
        Node fast = head;
        Node slow = head;

        for(int i=0; i < k; i++){
            if(fast==null) return dummy.next;
            else fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * delete middle node
     *
     * find the middle element, copy its previous node to it, and remove its next node
     *
     * Current implementation deals with 1 or 2 nodes badly, maybe add dummy node.
     */
    public static Node deleteMid(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }else{
                break;
            }
        }
        Node next = slow.next;
        if (next ==null){
            slow = null;
        }else {
            slow.data = next.data;
            slow.next = next.next;
        }
        return head;
    }
}

/**
 * definition for linked list
 */
class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next ){
        this.data = data;
        this.next = next;
    }

    public void append(Node node){
        Node ptr = this;
        while(ptr.next != null){
             ptr = ptr.next;
        }
        ptr.next = node;
    }

    public Node deleteNode(Node head, int d){
        Node n = head;

        if(n.data == d){
            return head.next;
        }

        while(n.next != null){
            if(n.next.data == d){
                n.next = next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
