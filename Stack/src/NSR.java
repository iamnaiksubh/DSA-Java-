import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

//Nearest smallest element on the right side
public class NSR {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            ar.add(sc.nextInt());
        }

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> nsr = new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            if(st.size() == 0)
                nsr.add(-1);
            else if(st.size() > 0 && ar.get(i) > st.peek())
                nsr.add(st.peek());
            else if(st.size() > 0 && ar.get(i) < st.peek()){

                while(st.size() > 0 && ar.get(i) <= st.peek()){
                    st.pop();
                }

                if(st.empty())
                    nsr.add(-1);
                else
                    nsr.add(st.peek());
            }
            st.push(ar.get(i));
        }
        Collections.reverse(nsr);
        System.out.print(nsr);
    }
}
