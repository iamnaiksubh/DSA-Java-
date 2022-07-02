// form a linkedlist fron the array
import java.util.Scanner;

public class ArrayToSLL {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

//    Printing Data Of LinkedList
    static void printSll(Node h){

        while(h != null){
            System.out.print(h.data + "->");
            h = h.next;
        }
        System.out.println("Null");
    }

//    Length Of LinkedList
    static int LengthOfSll(Node head){
        int len = 0;

        while(head != null){
            len++;
            head = head.next;
        }

        return len;
    }

//    Reverse Of LinkedList Using Recursion
    static void reverseSll(Node h){

        if(h == null)
            return;

        reverseSll(h.next);
        System.out.print(h.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];

        for(int i=0;i<n;i++){
            ar[i] = sc.nextInt();
        }
        Node head = new Node(ar[0]);
        Node temp = head;

        for(int i=1;i<n;i++){
            Node nn = new Node(ar[i]);
            temp.next = nn;
            temp = temp.next;
        }

        printSll(head);
        System.out.println("Length of ll : " + LengthOfSll(head));
        reverseSll(head);
    }
}
