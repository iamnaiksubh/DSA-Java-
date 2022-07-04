import java.util.Scanner;
class ListNode{
    int data;
    ListNode next;
    ListNode bottom;

    ListNode(int data){
        this.data = data;
        next = bottom = null;
    }
}

public class FlatteningLL {
    public static void insert(ListNode h, int ar[]){

        for(int i=1;i<ar.length;i++){
            ListNode nn = new ListNode(ar[i]);
            h.bottom = nn;
            h = h.bottom;
        }
    }

    public static ListNode merge(ListNode h1,ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        ListNode temp = new ListNode(0);
        ListNode hh = temp;
        while(h1 != null && h2 != null){
            if(h1.data <= h2.data){
                temp.bottom = h1;
                h1 = h1.bottom;
            }
            else{
                temp.bottom = h2;
                h2 = h2.bottom;
            }
            temp = temp.bottom;
        }

        if(h1 != null)
            temp.bottom = h1;

        if(h2 != null)
            temp.bottom = h2;

        return hh.bottom;

    }
    public static ListNode flatten(ListNode h){
        if(h == null || h.next == null) return h;

        h.next = flatten(h.next);
        return  merge(h,h.next);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //size of bottom linkedlist
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();

        int l1[] = new int[n1];
        int l2[] = new int[n2];
        int l3[] = new int[n3];
        int l4[] = new int[n4];

        for(int i=0;i<n1;i++)
            l1[i] = sc.nextInt();
        for(int i=0;i<n2;i++)
            l2[i] = sc.nextInt();
        for(int i=0;i<n3;i++)
            l3[i] = sc.nextInt();
        for(int i=0;i<n4;i++)
            l4[i] = sc.nextInt();

        ListNode h1 = new ListNode(l1[0]);
        ListNode h2 = new ListNode(l2[0]);
        ListNode h3 = new ListNode(l3[0]);
        ListNode h4 = new ListNode(l4[0]);

        insert(h1,l1);
        insert(h2,l2);
        insert(h3,l3);
        insert(h4,l4);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;

        ListNode temp = flatten(h1);

        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.bottom;
        }
        System.out.print("null");
    }
}
