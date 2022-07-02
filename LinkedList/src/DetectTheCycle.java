import java.util.Scanner;

public class DetectTheCycle {
    static Boolean isCycle(Node h){
        if(h == null || h.next == null)
            return false;
        Node slow = h, fast = h;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int list[] = new int[n];

        for(int i=0;i<n;i++)
            list[i] = sc.nextInt();

        Node head1 = null;

        head1 = new Node(list[0]);

        Node t = head1, temp = null;
        for(int i=1;i<n;i++){
            Node nn = new Node(list[i]);
            t.next = nn;
            t = t.next;
            if(i == 1)
                temp = nn;
        }

        t.next = temp;

        System.out.println(isCycle(head1) ? "Cycle Exist" : "No Cycle Exist");

    }
}
