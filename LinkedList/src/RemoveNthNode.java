// Remove the Nth Node from the end of the linkedlist
import java.util.*;
import java.io.*;

//class Node{
//    int data;
//    Node next;
//
//    Node(int data){
//        this.data = data;
//        next = null;
//    }
//}

public class RemoveNthNode {
    static void print(Node head){

        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    static Node removeNthNode(Node head, int n){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast,slow;
        fast = slow = dummy;

        for(int i=1;i<=n;i++)
            fast = fast.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node t = head;

        Scanner sc = new Scanner(System.in);
        t.next = new Node(2);
        t = t.next;
        t.next = new Node(3);
        t = t.next;
        t.next = new Node(4);
        int n;
        n = sc.nextInt();
        print(head);
        head = removeNthNode(head,n);
        print(head);
    }
}
