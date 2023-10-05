import java.io.*;
import java.util.*;

public class Main {
    static int[] stack;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (n-- > 0) {
            String str = st.nextToken();
            switch(str) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                default:
                    sb.append(top()).append("\n");
                    break;
            }
            if (n > 0) st = new StringTokenizer(br.readLine(), " ");
        }
        System.out.println(sb);
    }
    
    public static void push(int x) {
        stack[size] = x;
        size++;
    }
    public static int pop() {
        if (size == 0) return -1;
        else {
            int x = stack[size - 1];
            size--;
            return x;
        }
    }
    public static int size() {
        return size;
    }
    public static int empty() {
        if (size == 0) return 1;
        else return 0;
    }
    public static int top() {
        if (size == 0) return -1;
        else return stack[size - 1];
    }
}
