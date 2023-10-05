import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        st = new StringTokenizer(br.readLine(), " ");

        while (n-- > 0) {
            String str = st.nextToken();
            if (str.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (str.equals("pop")) {
                System.out.println(stack.empty()? -1 : stack.pop());
            } else if (str.equals("size")) {
                System.out.println(stack.size());
            } else if (str.equals("empty")) {
                System.out.println(stack.empty() ? 1 : 0);
            } else if (str.equals("top")){
                System.out.println(stack.empty() ? -1 : stack.peek());
            }

            if (n > 0) st = new StringTokenizer(br.readLine(), " ");
        }


    }
}
