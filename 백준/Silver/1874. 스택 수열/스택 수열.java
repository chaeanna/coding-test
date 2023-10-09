import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > idx) {
                while (idx  < input) {
                    stack.push(idx+1);
                    sb.append("+").append("\n");
                    idx++;
                }

            } else if (stack.peek() != input) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");

        }
        System.out.println(sb);

    }
}
