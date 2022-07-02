import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

//Nearest greater to left
public class NGL {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            ar.add(sc.nextInt());
        }

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ngl = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(st.size() == 0)
                ngl.add(-1);
            else if(st.size() > 0 && ar.get(i) < st.peek())
                ngl.add(st.peek());
            else if(st.size() > 0 && ar.get(i) > st.peek()){

                while(st.size() > 0 && ar.get(i) >= st.peek()){
                    st.pop();
                }

                if(st.empty())
                    ngl.add(-1);
                else
                    ngl.add(st.peek());
            }
            st.push(ar.get(i));
        }
//        Collections.reverse(nsr);
//        System.out.print(nsr);

        for(Integer i : ngl)
            System.out.print(i + " ");
    }
}
