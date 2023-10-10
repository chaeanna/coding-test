import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            while (!stack.empty()) {
                if (stack.peek()[1] <= input) {
                    stack.pop();
                } else {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
            }
            if (stack.empty()) {
                sb.append(0).append(" ");
            }
            stack.push(new int[] {i, input});
        }

        System.out.println(sb);
    }
}
