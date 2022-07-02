import java.io.*;
import java.util.*;

public class Stacks {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);

        System.out.println("Stack : " + st);

        System.out.println("Peek :" + st.peek());

        System.out.println("Pop :" + st.pop());

        System.out.println("Stack : " + st);
    }
}