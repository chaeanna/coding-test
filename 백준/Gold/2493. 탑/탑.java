import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int j = 1; j <= n; j++) {
            while (!stack.empty() && input[j] >= input[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) result[j-1] = 0;
            else {
                result[j-1] = stack.peek();
            }
            stack.push(j);
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
