import java.util.Scanner;

public class RotateRight {
    static Node rotateRight(Node head, int k){
        if(head == null || head.next == null || k == 0) return head;

        Node curr = head;
        int cnt = 1;

        while(curr.next != null){
            cnt++;
            curr = curr.next;
        }

        curr.next = head;
        k = k%cnt;
        k = cnt - k;

        while(k-- > 0){
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];

        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();

        int k = sc.nextInt();
        Node head = new Node(ar[0]);
        Node temp = head;

        for(int i=1;i<n;i++){
            Node nn = new Node(ar[i]);
            temp.next = nn;
            temp = temp.next;
        }

        head = rotateRight(head,k);

        while(head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
    }
}
