import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        st = new StringTokenizer(br.readLine(), " ");

        while (n-- > 0) {
            String str = st.nextToken();
            if (str.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (str.equals("pop")) {
                sb.append(stack.empty()? -1 : stack.pop()).append("\n");
            } else if (str.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (str.equals("empty")) {
                sb.append(stack.empty() ? 1 : 0).append("\n");
            } else if (str.equals("top")){
                sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
            }

            if (n > 0) st = new StringTokenizer(br.readLine(), " ");
        }
        System.out.println(sb);


    }
}
