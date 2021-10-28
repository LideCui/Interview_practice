package DataStructures.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @BeforeEach

    @Test
    void removeDup() {
    }

    @Test
    void lastKthNode() {

    }

    @Test
    void deleteMid() {
        Node head = new Node(0);
        head.append(new Node(1));
        head.append(new Node(2));
        head.append(new Node(3));
        head.append(new Node(4));
        MyLinkedList.deleteMid(head);
        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}