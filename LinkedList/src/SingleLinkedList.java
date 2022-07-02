// Basic single linkedlist
public class SingleLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static void printSll(Node h){
        while(h != null){
            System.out.print(h.data + "->");
            h = h.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printSll(head);

    }
}